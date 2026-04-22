package mk.ukim.finki.routingsystem.repository;

import mk.ukim.finki.routingsystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Company} entities.
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

  /**
   * Checks whether a company with the given code already exists.
   *
   * @param code the unique company code to check
   * @return true if a company with the given code exists, false otherwise
   */
  boolean existsByCode(String code);

}
