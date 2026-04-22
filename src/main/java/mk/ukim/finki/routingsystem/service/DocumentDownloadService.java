package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;

import java.util.List;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.documentEntities.DocumentDownload} entities.
 */

public interface DocumentDownloadService {

  /**
   * Lists all Downloads made by an employee within a company.
   *
   * @param employeeId the id of the given employee
   * @param companyId  the id of the given company
   * @return list of {@link DisplayDocumentDownloadDto} representing the downloads that match the employee and company
   */
  List<DisplayDocumentDownloadDto> findAllDownloadsByEmployee(Long employeeId, Long companyId);

  /**
   * Lists all the Downloads made on a document within a company.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @return list of {@link DisplayDocumentDownloadDto} representing all the downloads that match the document and company
   */
  List<DisplayDocumentDownloadDto> findAllDownloadsByDocument(Long documentId, Long companyId);

}
