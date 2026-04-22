package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for managing {@link Department} entities.
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  /**
   * Lists all Departments that match the given list of department keys within a company.
   *
   * @param departmentKey list of department keys to filter by
   * @param companyId     the id of the given company
   * @return list of {@link Department} matching the given keys and company
   */
  List<Department> findAllByDepartmentKeyInAndCompany_Id(List<String> departmentKey, Long companyId);

  /**
   * Lists all Departments within a company.
   *
   * @param companyId the id of the given company
   * @return list of {@link Department} matching the company
   */
  List<Department> findAllByCompany_Id(Long companyId);

  /**
   * Lists all Departments by given department id within a company.
   *
   * @param id        the id of the given department
   * @param companyId the id of the given company
   * @return an {@link Optional} containing the matching {@link Department} or empty if not found
   */
  Optional<Department> findByIdAndCompany_Id(Long id, Long companyId);

  /**
   * Lists all Departments by given department key within a company.
   *
   * @param departmentKey the key of the given department
   * @param companyId     the id of the given company
   * @return an {@link Optional} containing the matching {@link Department} or empty if not found
   */
  Optional<Department> findByDepartmentKeyAndCompany_Id(String departmentKey, Long companyId);

}
