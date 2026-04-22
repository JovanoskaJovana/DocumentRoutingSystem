package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.ManualReviewAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing the {@link ManualReviewAction} entities.
 */

@Repository
public interface ManualReviewActionRepository extends JpaRepository<ManualReviewAction, Long> {

  /**
   * Lists all the manual review actions for a given department within a company.
   *
   * @param companyId    the id of the given company
   * @param departmentId the id of the given department
   * @return list of {@link ManualReviewAction} that match the department and company
   */
  List<ManualReviewAction> findAllByCompany_IdAndManualChosenDepartment_Id(Long companyId, Long departmentId);
}
