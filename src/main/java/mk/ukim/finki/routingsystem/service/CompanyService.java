package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.Company.CreateCompanyDto;
import mk.ukim.finki.routingsystem.model.dto.Company.ResponseCompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.Company} entities.
 */

public interface CompanyService {

  /**
   * Finds a company by its id.
   *
   * @param companyId the id of the given company
   * @return a {@link ResponseCompanyDto} representing the found company
   * @throws mk.ukim.finki.routingsystem.model.exceptions.CompanyNotFoundException if no company is found with the given id
   */
  ResponseCompanyDto findCompanyById(Long companyId);

  /**
   * Retrieves a paginated list of all companies.
   *
   * @param pageable pagination and sorting information
   * @return a {@link Page} of {@link ResponseCompanyDto} representing all companies
   */
  Page<ResponseCompanyDto> listAll(Pageable pageable);

  /**
   * Creates and saves a new company.
   *
   * @param createCompanyDto the data required to create a new company
   * @return a {@link ResponseCompanyDto} representing the created company
   */
  ResponseCompanyDto save(CreateCompanyDto createCompanyDto);

  /**
   * Toggles the active status of a company.
   *
   * @param companyId the id of the given company
   * @return a {@link ResponseCompanyDto} representing the updated company
   * @throws mk.ukim.finki.routingsystem.model.exceptions.CompanyNotFoundException if no company if found with the given id
   */
  ResponseCompanyDto changeActivity(Long companyId);

}
