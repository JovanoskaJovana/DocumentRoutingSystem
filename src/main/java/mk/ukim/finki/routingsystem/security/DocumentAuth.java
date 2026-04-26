package mk.ukim.finki.routingsystem.security;

import mk.ukim.finki.routingsystem.model.documentEntities.Document;
import mk.ukim.finki.routingsystem.model.enumerations.EmployeeType;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException;
import mk.ukim.finki.routingsystem.repository.DocumentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Component for evaluating document-level authorization rules.
 */

@Component("documentAuth")
public class DocumentAuth {

  private final DocumentRepository documentRepository;

  public DocumentAuth(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  /**
   * Returns true if the authenticated employee has a SIGNATORY type.
   *
   * @param authentication the current authentication
   * @return true if the employee is a SIGNATORY and works in the same department to which the document is routed, false otherwise
   */
  public boolean canSign(Long documentId, Long companyId, Authentication authentication) {

    if (authentication == null || !(authentication.getPrincipal() instanceof EmployeePrincipal employeePrincipal)) {
      return false;
    }

    Document document = documentRepository.findByIdAndCompany_Id(documentId, companyId)
            .orElseThrow(() -> new DocumentNotFoundException("Document not found."));

    if (document == null) {
      return false;
    }

    boolean sameDepartment = document.getRoutedToDepartment() != null &&
            employeePrincipal.departmentId() != null &&
            document.getRoutedToDepartment().getId().equals(employeePrincipal.departmentId());

    boolean isSignatory = employeePrincipal.employeeType() == EmployeeType.SIGNATORY;

    return sameDepartment && isSignatory;
  }

}

