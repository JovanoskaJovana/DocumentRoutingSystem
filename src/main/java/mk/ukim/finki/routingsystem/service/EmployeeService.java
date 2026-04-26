package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.Employee.CreateDisplayEmployeeDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.Employee} entities.
 */

public interface EmployeeService {

  /**
   * Lists all employees within a company.
   *
   * @param companyId the id of the given company
   * @return list of {@link CreateDisplayEmployeeDto} representing all employees
   */
  List<CreateDisplayEmployeeDto> listAll(Long companyId);

  /**
   * Finds an employee by its id within a company.
   *
   * @param id        the id of the given employee
   * @param companyId the id of the given company
   * @return an {@link Optional} of {@link CreateDisplayEmployeeDto} representing the employee
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DepartmentNotFoundException the given id of the department is not found
   */
  Optional<CreateDisplayEmployeeDto> findById(Long id, Long companyId);

  /**
   * Creates a new employee within a company.
   *
   * @param createDisplayEmployeeDto the data required to create the employee
   * @param companyId                the id of the given company
   * @return a {@link CreateDisplayEmployeeDto} representing the created employee
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DepartmentNotFoundException if the given id of the department is not found
   */
  CreateDisplayEmployeeDto save(CreateDisplayEmployeeDto createDisplayEmployeeDto, Long companyId);

  /**
   * Updates an existing employee within a company.
   *
   * @param employeeId               the id of the given employee
   * @param createDisplayEmployeeDto the updated data for the employee
   * @param companyId                the id of the given company
   * @return an {@link Optional} of {@link CreateDisplayEmployeeDto} representing the updated employee
   */
  Optional<CreateDisplayEmployeeDto> update(Long employeeId, CreateDisplayEmployeeDto createDisplayEmployeeDto, Long companyId);

  /**
   * Deletes an employee by its id within a company.
   *
   * @param employeeId the id of the employee to be deleted
   * @param companyId  the id of the given company
   * @return true if the employee is successfully deleted, false otherwise
   * @throws mk.ukim.finki.routingsystem.model.exceptions.EmployeeNotFoundException if the given id of the employee is not found
   */
  boolean delete(Long employeeId, Long companyId);

}
