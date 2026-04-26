package mk.ukim.finki.routingsystem.model.dto.Employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.routingsystem.model.enumerations.EmployeeType;
import mk.ukim.finki.routingsystem.model.enumerations.Role;

/**
 * DTO for creating and displaying employee information.
 *
 * @param employeeId   the id of the employee
 * @param email        the email of the employee
 * @param password     the password of the employee
 * @param firstName    the first name of the employee
 * @param lastName     the last name of the employee
 * @param departmentId the id of the department in which the employee works
 * @param role         the role of the employee within the company
 * @param employeeType the type of the employee within the company
 * @param companyId    the id of the company in which the employee works
 */

public record CreateDisplayEmployeeDto(

        Long employeeId,
        String email,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password,
        String firstName,
        String lastName,
        Long departmentId,
        Role role,
        EmployeeType employeeType,
        Long companyId

) {
}
