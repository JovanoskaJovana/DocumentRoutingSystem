package mk.ukim.finki.routingsystem.security;

import lombok.Getter;
import mk.ukim.finki.routingsystem.model.enumerations.EmployeeType;
import mk.ukim.finki.routingsystem.model.enumerations.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of {@link UserDetails} representing an authenticated employee.
 *
 * @param employeeId   the id of the employee
 * @param firstName    the first name of the employee
 * @param role         the role of the employee
 * @param employeeType the type of the employee
 * @param departmentId the id of the department the employee belongs to
 * @param companyId    the id of the company the employee belongs to
 */

@Getter
public record EmployeePrincipal(Long employeeId, String firstName, Role role, EmployeeType employeeType,
                                Long departmentId, Long companyId) implements UserDetails {

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of((GrantedAuthority) () -> "ROLE_" + role.name());
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return employeeId.toString();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
