package mk.ukim.finki.routingsystem.listeners;

import mk.ukim.finki.routingsystem.events.DocumentActionRequestedEvent;
import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.documentEntities.Document;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentAction;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentVersionNotFoundException;
import mk.ukim.finki.routingsystem.model.exceptions.EmployeeNotFoundException;
import mk.ukim.finki.routingsystem.repository.DocumentActionRepository;
import mk.ukim.finki.routingsystem.repository.DocumentRepository;
import mk.ukim.finki.routingsystem.repository.DocumentVersionRepository;
import mk.ukim.finki.routingsystem.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Event listener responsible for persisting document actions after a transaction is committed.
 */

@Component
public class DocumentActionListener {

  private final DocumentRepository documentRepository;
  private final EmployeeRepository employeeRepository;
  private final DocumentActionRepository documentActionRepository;
  private final DocumentVersionRepository documentVersionRepository;

  public DocumentActionListener(DocumentRepository documentRepository, EmployeeRepository employeeRepository, DocumentActionRepository documentActionRepository, DocumentVersionRepository documentVersionRepository) {
    this.documentRepository = documentRepository;
    this.employeeRepository = employeeRepository;
    this.documentActionRepository = documentActionRepository;
    this.documentVersionRepository = documentVersionRepository;
  }

  /**
   * Handles a {@link DocumentActionRequestedEvent} by creating and saving a {@link DocumentAction}.
   * Runs asynchronously after the triggering transaction has been committed.
   *
   * @param event the event containing the data required to record the action
   * @throws DocumentNotFoundException        if the document is not found
   * @throws DocumentVersionNotFoundException if the document version is not found
   * @throws EmployeeNotFoundException        if the employee is not found
   */
  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  @Async
  public void on(DocumentActionRequestedEvent event) {
    Document document = documentRepository.findById(event.documentId())
            .orElseThrow(() -> new DocumentNotFoundException("Document not found."));

    DocumentVersion documentVersion = (event.versionId() != null ? documentVersionRepository.findById(event.versionId())
            .orElseThrow(() -> new DocumentVersionNotFoundException("Document version not found."))
            : document.getCurrentDocumentVersion());

    Employee employee = (event.employeeId() != null) ? employeeRepository.findById(event.employeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"))
            : null;

    DocumentAction documentAction = new DocumentAction();
    documentAction.setDocument(document);
    documentAction.setDocumentVersion(documentVersion);
    documentAction.setPerformedByEmployee(employee);
    documentAction.setActionDateTime(event.dateTime());
    documentAction.setFromStatus(event.fromStatus());
    documentAction.setToStatus(event.toStatus());
    documentAction.setPerformedAction(event.actionType());
    documentAction.setNotes(buildNotes(document, employee, event));

    documentActionRepository.save(documentAction);
  }

  /**
   * Builds a human-readable note describing the action performed on the document.
   *
   * @param document the document the action was performed on
   * @param employee the employee that performed the action, or null if unknown
   * @param event    the event containing the action type and status details
   * @return a string describing the performed action
   */
  private static String buildNotes(Document document, Employee employee, DocumentActionRequestedEvent event) {

    String employeeName = (employee == null) ? "Unknown" : employee.getFirstName() + " " + employee.getLastName();
    return switch (event.actionType()) {
      case UPLOADED -> "Document" + document.getTitle() + " has been uploaded by employee " + employeeName;
      case ROUTED -> "Document status change: " + event.fromStatus() + " -> " + event.toStatus();
      case EDITED -> "Document" + document.getTitle() + " has been edited by employee " + employeeName;
      case APPROVED -> "Document" + document.getTitle() + " has been approved by employee " + employeeName;
      case REJECTED -> "Document" + document.getTitle() + " has been rejected by employee " + employeeName;
      case FAILED_ROUTING -> "Document" + document.getTitle() + " has failed to route";
      case DOWNLOADED -> "Document" + document.getTitle() + " has been downloaded by employee " + employeeName;
    };
  }

}
