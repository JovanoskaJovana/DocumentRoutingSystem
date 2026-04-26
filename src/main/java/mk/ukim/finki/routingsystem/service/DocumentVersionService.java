package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.DocumentVersion.CreateDocumentVersionDto;
import mk.ukim.finki.routingsystem.model.dto.DocumentVersion.DisplayDocumentVersionDto;
import mk.ukim.finki.routingsystem.model.dto.DocumentVersion.UpdateDocumentAndVersionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for {@link mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion} entities.
 */

public interface DocumentVersionService {

  /**
   * Retrieves a paginated list of all the versions from a given document within a company.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @param pageable   pagination and sorting information
   * @return a {@link Page} of {@link DisplayDocumentVersionDto} representing all the versions
   */
  Page<DisplayDocumentVersionDto> listAllVersionsOfADocument(Long documentId, Long companyId, Pageable pageable);

  /**
   * Creates a new Version for a given document within a company.
   *
   * @param createDocumentVersionDto the data required to create the new version
   * @param companyId                the id of the given company
   * @return a {@link DisplayDocumentVersionDto} representing the created version
   * @throws mk.ukim.finki.routingsystem.model.exceptions.EmployeeNotFoundException if the given id of the employee is not found
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException if the given id of the document is not found
   */
  DisplayDocumentVersionDto createAndSaveADocumentVersion(CreateDocumentVersionDto createDocumentVersionDto, Long companyId);

  /**
   * Updates an existing Version for a given document within a company.
   *
   * @param documentId                  the id of the given document
   * @param updateDocumentAndVersionDto the data used for updating the document
   * @param companyId                   the id of the given company
   * @return a {@link DisplayDocumentVersionDto} representing the updated version
   * @throws mk.ukim.finki.routingsystem.model.exceptions.EmployeeNotFoundException        if the given id of the employee is not found
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException        if the given id of the document is not found
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DocumentVersionNotFoundException if the given id of the document version is not found
   * @throws mk.ukim.finki.routingsystem.model.exceptions.RequiredChangeNoteException      if change note is not sent
   * @throws mk.ukim.finki.routingsystem.model.exceptions.RequiredEmployeeIdException      if the id of the employee that updates the document is not sent
   */
  DisplayDocumentVersionDto updateAndSaveDocumentVersion(Long documentId, UpdateDocumentAndVersionDto updateDocumentAndVersionDto, Long companyId);

  /**
   * Retrieves the document version by its id within a company.
   *
   * @param documentVersionId the id of the given version
   * @param companyId         the id of the given company
   * @return a {@link DisplayDocumentVersionDto} representing the version that matches the id and the company
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DocumentVersionNotFoundException if the given id of the document version is not found
   */
  DisplayDocumentVersionDto getDocumentVersion(Long documentVersionId, Long companyId);

}
