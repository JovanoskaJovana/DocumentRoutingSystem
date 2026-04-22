package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.documentEntities.Document;
import mk.ukim.finki.routingsystem.model.enumerations.DocumentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for managing {@link Document} entities.
 */

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

  /**
   * Retrieves a paginated list of documents routed to a given department within a company, ordered by upload date and time.
   * Eagerly loads the current document version.
   *
   * @param departmentId the id of the given department
   * @param companyId    the id of the given company
   * @param pageable     pagination and sorting information
   * @return a {@link Page} of {@link Document} matching the given department and company id
   */
  @EntityGraph(attributePaths = {"currentDocumentVersion"})
  Page<Document> findAllByRoutedToDepartment_IdAndCompany_IdOrderByUploadDateTime(Long departmentId, Long companyId, Pageable pageable);

  /**
   * Retrieves a paginated list of documents that match given statuses and are routed to a specific employee within a company, ordered by upload date and time.
   * Eagerly loads the current document version.
   *
   * @param statuses   the given list of statuses
   * @param employeeId the id of the employee that documents are routed to
   * @param companyId  the id of the given company
   * @param pageable   pagination and sorting information
   * @return a {@link Page} of {@link Document} matching the given statuses, employee and company
   */
  @EntityGraph(attributePaths = {"currentDocumentVersion"})
  Page<Document> findAllByDocumentStatusInAndRoutedToEmployees_IdAndCompany_IdOrderByUploadDateTime(List<DocumentStatus> statuses, Long employeeId, Long companyId, Pageable pageable);

  /**
   * Retrieves a paginated list of documents that match given statuses and are uploaded by a specific employee within a company, ordered by upload date and time.
   * Eagerly loads the current document version.
   *
   * @param statuses   the given list of statuses
   * @param employeeId the id of the employee that uploaded the documents
   * @param companyId  the id of the given company
   * @param pageable   pagination and sorting information
   * @return a {@link Page} of {@link Document} matching the given statuses, employee and company
   */
  @EntityGraph(attributePaths = {"currentDocumentVersion"})
  Page<Document> findAllByDocumentStatusInAndUploadedByEmployee_IdAndCompany_IdOrderByUploadDateTime(List<DocumentStatus> statuses, Long employeeId, Long companyId, Pageable pageable);

  /**
   * Returns the document by given id within a company.
   * Eagerly retrieves the current and all document versions.
   *
   * @param id        the id of the given document
   * @param companyId the id of the given company
   * @return an {@link Optional} of {@link Document} matching the given document and company
   */
  @EntityGraph(attributePaths = {"currentDocumentVersion", "allDocumentVersions"})
  Optional<Document> findWithVersionsByIdAndCompany_Id(Long id, Long companyId);

  /**
   * Returns the document by given id within a company.
   *
   * @param id        the id of the given document
   * @param companyId the id of the given company
   * @return an {@link Optional} of {@link Document} matching the given document and company
   */
  Optional<Document> findByIdAndCompany_Id(Long id, Long companyId);

}
 