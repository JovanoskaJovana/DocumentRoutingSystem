package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.DocumentAction.DisplayDocumentActionDto;

import java.util.List;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.documentEntities.DocumentAction} entities.
 */

public interface DocumentActionService {

  /**
   * Finds all Actions made on a document within a company.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @return list of {@link DisplayDocumentActionDto} representing the actions that match the document and company
   */
  List<DisplayDocumentActionDto> findAllForADocument(Long documentId, Long companyId);

  /**
   * Finds all actions made on a document by a specific employee within a company.
   *
   * @param employeeId the id of the given employee
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @return list of {@link DisplayDocumentActionDto} representing the actions that match the employee, document and company
   */
  List<DisplayDocumentActionDto> findAllBySpecificEmployee(Long employeeId, Long documentId, Long companyId);

}
