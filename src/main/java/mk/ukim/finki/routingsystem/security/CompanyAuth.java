package mk.ukim.finki.routingsystem.security;

import mk.ukim.finki.routingsystem.model.enumerations.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Component for evaluating company-level authorization rules.
 */

@Component("companyAuth")
public class CompanyAuth {

  /**
   * Returns true if the authenticated employee has the SUPER_ADMIN role.
   *
   * @param authentication the current authentication
   * @return true if the employee is a SUPER_ADMIN, false otherwise
   */
  public boolean canChangeActivity(Authentication authentication) {

    if (authentication == null || !(authentication.getPrincipal() instanceof EmployeePrincipal employeePrincipal)) {
      return false;
    }

    return employeePrincipal.role() == Role.SUPER_ADMIN;
  }

  /**
   * Returns true if the authenticated employee has the SUPER_ADMIN role.
   *
   * @param authentication the current authentication
   * @return true if the employee is a SUPER_ADMIN, false otherwise
   */
  public boolean canCreateCompany(Authentication authentication) {

    if (authentication == null || !(authentication.getPrincipal() instanceof EmployeePrincipal employeePrincipal)) {
      return false;
    }

    return employeePrincipal.role() == Role.SUPER_ADMIN;
  }

}
