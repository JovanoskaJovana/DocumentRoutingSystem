package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.Department;
import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.enumerations.EmployeeType;
import mk.ukim.finki.routingsystem.model.enumerations.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Repository for managing {@link Employee} entities.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  /**
   * Returns a set of employees that match the given employee type in the given department within a company.
   *
   * @param companyId    the id of the given company
   * @param departmentId the id of the given department
   * @param employeeType the given type of the employee
   * @return set of {@link Employee} that match the department, company and type
   */
  Set<Employee> findAllByCompany_IdAndDepartment_IdAndType(Long companyId, Long departmentId, EmployeeType employeeType);

  /**
   * Retrieves the employee that matches the given email within a company.
   *
   * @param email       the given email of the employee
   * @param companyCode the given code of the company
   * @return an {@link Optional} of {@link Employee} that matches the email and company
   */
  Optional<Employee> findByEmailAndCompany_Code(String email, String companyCode);

  /**
   * Retrieves the employee that matches the given email and role.
   *
   * @param email the given email of the employee
   * @param role  the given role of the employee
   * @return an {@link Optional} of {@link Employee} that matches the email and role
   */
  Optional<Employee> findByEmailAndRole(String email, Role role);

  /**
   * Lists all employees within a company.
   *
   * @param companyId the id of the given company
   * @return list of {@link Employee} that match the company
   */
  List<Employee> findAllByCompany_Id(Long companyId);

  /**
   * Retrieves the employee that matches the given id within a company.
   *
   * @param id        the id of the given employee
   * @param companyId the id of the given company
   * @return an {@link Optional} of {@link Employee} that matches the id and the company
   */
  Optional<Employee> findByIdAndCompany_Id(Long id, Long companyId);
}
