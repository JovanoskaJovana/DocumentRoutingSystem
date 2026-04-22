package mk.ukim.finki.routingsystem.listeners;

import mk.ukim.finki.routingsystem.events.DocumentDownloadRequestedEvent;
import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.documentEntities.Document;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentDownload;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentVersionNotFoundException;
import mk.ukim.finki.routingsystem.model.exceptions.EmployeeNotFoundException;
import mk.ukim.finki.routingsystem.repository.DocumentDownloadRepository;
import mk.ukim.finki.routingsystem.repository.DocumentRepository;
import mk.ukim.finki.routingsystem.repository.DocumentVersionRepository;
import mk.ukim.finki.routingsystem.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

/**
 * Event listener responsible for persisting document downloads after a transaction is committed.
 */

@Component
@EnableAsync
public class DocumentDownloadListener {

  private final DocumentRepository documentRepository;
  private final DocumentVersionRepository documentVersionRepository;
  private final EmployeeRepository employeeRepository;
  private final DocumentDownloadRepository documentDownloadRepository;

  public DocumentDownloadListener(DocumentRepository documentRepository, DocumentVersionRepository documentVersionRepository, EmployeeRepository employeeRepository, DocumentDownloadRepository documentDownloadRepository) {
    this.documentRepository = documentRepository;
    this.documentVersionRepository = documentVersionRepository;
    this.employeeRepository = employeeRepository;
    this.documentDownloadRepository = documentDownloadRepository;
  }

  /**
   * Handles a {@link DocumentDownloadRequestedEvent} by creating and saving a {@link DocumentDownload}.
   * Runs asynchronously after the triggering transaction has been committed.
   *
   * @param event the event containing the data required to record the action
   * @throws DocumentNotFoundException        if the document is not found
   * @throws DocumentVersionNotFoundException if the document version is not found
   * @throws EmployeeNotFoundException        if the employee is not found
   */
  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  @Async
  public void on(DocumentDownloadRequestedEvent event) {

    Document document = documentRepository.findById(event.documentId())
            .orElseThrow(() -> new DocumentNotFoundException("Document not found"));

    DocumentVersion documentVersion = event.versionId() != null ? documentVersionRepository.findById(event.versionId())
            .orElseThrow(() -> new DocumentVersionNotFoundException("Document version not found"))
            : null;

    Employee employee = event.employeeId() != null ? employeeRepository.findById(event.employeeId())
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"))
            : null;

    DocumentDownload documentDownload = new DocumentDownload();
    documentDownload.setDocument(document);
    documentDownload.setDocumentVersion(documentVersion);
    documentDownload.setEmployee(employee);
    documentDownload.setDownloadDateTime(LocalDateTime.now());
    documentDownloadRepository.save(documentDownload);

  }

}
