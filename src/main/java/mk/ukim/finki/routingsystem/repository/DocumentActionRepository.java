package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.documentEntities.DocumentAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing {@link DocumentAction} entities.
 */

@Repository
public interface DocumentActionRepository extends JpaRepository<DocumentAction, Long> {

  /**
   * Lists all Actions made on a document within a company, ordered by date and time.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @return list of {@link DocumentAction} matching the given document and company
   */
  List<DocumentAction> findByDocument_IdAndDocument_Company_IdOrderByActionDateTime(Long documentId, Long companyId);

  /**
   * Lists all Actions made on a document by a given employee within a company, ordered by date and time.
   *
   * @param documentId            the id of the given document
   * @param performedByEmployeeId the id of the employee
   * @param companyId             the id of the given company
   * @return list of {@link DocumentAction} matching the given document, employee and company
   */
  List<DocumentAction> findByDocument_IdAndPerformedByEmployee_IdAndDocument_Company_IdOrderByActionDateTime(Long documentId, Long performedByEmployeeId, Long companyId);

}
