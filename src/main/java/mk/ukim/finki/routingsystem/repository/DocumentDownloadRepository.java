package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.documentEntities.DocumentDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing {@link DocumentDownload} entities.
 */

@Repository
public interface DocumentDownloadRepository extends JpaRepository<DocumentDownload, Long> {

  /**
   * Lists all Downloads by a given employee within a company.
   *
   * @param id the id of the employee
   * @param companyId the id of the given company
   * @return list of {@link DocumentDownload} matching the given employee and company
   */
  List<DocumentDownload> findAllByEmployee_IdAndDocument_Company_IdOrderByDownloadDateTimeDesc(Long id, Long companyId);

  /**
   * Lists all Downloads made on a document within a company.
   *
   * @param id the id of the given document
   * @param companyId the id of the given company
   * @return list of {@link DocumentDownload} matching the given document and company
   */
  List<DocumentDownload> findAllByDocument_IdAndDocument_Company_Id(Long id, Long companyId);

}
