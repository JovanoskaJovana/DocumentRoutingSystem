package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing {@link DocumentVersion} entities.
 */

@Repository
public interface DocumentVersionRepository extends JpaRepository<DocumentVersion, Long> {

  /**
   * Retrieves a paginated list of Versions for a given document within a company, ordered by version number descending.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @param pageable   pagination and sorting information
   * @return a {@link Page} of {@link DocumentVersion} matching the given document and company
   */
  Page<DocumentVersion> findByDocument_IdAndDocument_Company_IdOrderByVersionNumberDesc(Long documentId, Long companyId, Pageable pageable);

  /**
   * Returns a Version by a given id within a company.
   *
   * @param versionId the id of the given version
   * @param companyId the id of the given company
   * @return an {@link Optional} of {@link DocumentVersion} matching the given version id and company
   */
  Optional<DocumentVersion> findByIdAndDocument_Company_Id(Long versionId, Long companyId);

}
