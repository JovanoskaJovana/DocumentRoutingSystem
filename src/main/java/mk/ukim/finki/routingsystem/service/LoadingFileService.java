package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.FileResource;

/**
 * Service interface for loading files for download.
 */

public interface LoadingFileService {

  /**
   * Loads the file from database for download.
   *
   * @param documentId the id of the given document
   * @param versionId  the id of the given version
   * @param companyId  the id of the given company
   * @return a {@link FileResource} representing the PDF file
   */
  FileResource loadFile(Long documentId, Long versionId, Long companyId);

}
