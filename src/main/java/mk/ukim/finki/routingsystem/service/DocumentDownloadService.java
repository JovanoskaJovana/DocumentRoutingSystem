package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.FileResource;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.PreparedDocumentDownload;

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

  /**
   * Prepares a document for a download within a company.
   *
   * @param documentId the id of the given document
   * @param versionId  the id of the version of the document we want to download
   * @param companyId  the id of the given company
   * @param employeeId the id of the employee that downloads the document
   * @return a {@link PreparedDocumentDownload} representing the PDF file and the file name of the version that will be downloaded
   */
  PreparedDocumentDownload prepareDownload(Long documentId, Long versionId, Long companyId, Long employeeId);

}
