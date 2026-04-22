package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.CreateDisplayDepartmentDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.Department} entities.
 */

public interface DepartmentService {

  /**
   * Lists all departments within a company.
   *
   * @param companyId the id of the given company
   * @return list of {@link CreateDisplayDepartmentDto} representing all departments
   */
  List<CreateDisplayDepartmentDto> listAll(Long companyId);

  /**
   * Finds a department by its id within a company.
   *
   * @param departmentId the id of the given department
   * @param companyId    the id of the given company
   * @return an {@link Optional} of {@link CreateDisplayDepartmentDto} representing the department
   */
  Optional<CreateDisplayDepartmentDto> findById(Long departmentId, Long companyId);

  /**
   * Creates and saves a new department within a company.
   *
   * @param createDisplayDepartmentDto the data required to create a new department
   * @param companyId                  the id of the given company
   * @return a {@link CreateDisplayDepartmentDto} representing the created department
   * @throws mk.ukim.finki.routingsystem.model.exceptions.CompanyNotFoundException if no company is found with the given id
   */
  CreateDisplayDepartmentDto save(CreateDisplayDepartmentDto createDisplayDepartmentDto, Long companyId);

  /**
   * Updates an existing department within a company.
   *
   * @param companyId                  the id of the given company
   * @param departmentId               the id of the given department
   * @param createDisplayDepartmentDto the updated data from the existing department
   * @return an {@link Optional} of {@link CreateDisplayDepartmentDto} representing the updated Department
   */
  Optional<CreateDisplayDepartmentDto> update(Long companyId, Long departmentId, CreateDisplayDepartmentDto createDisplayDepartmentDto);

  /**
   * Lists all departments suggested for manual routing review based on a given document.
   *
   * @param documentId the id of the given document
   * @param companyId  the id of the given company
   * @return list of {@link CreateDisplayDepartmentDto} representing the departments that match the document and company
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DocumentNotFoundException if no document is found with the given id
   */
  List<CreateDisplayDepartmentDto> getManualReviewDepartments(Long documentId, Long companyId);

  /**
   * Deletes a department by its id within a company.
   *
   * @param companyId    the id of the given company
   * @param departmentId the id of the department that needs to be deleted
   * @return true if department is successfully deleted, otherwise false
   * @throws mk.ukim.finki.routingsystem.model.exceptions.DepartmentNotFoundException if no department is found with the given id
   */
  boolean delete(Long companyId, Long departmentId);
}
