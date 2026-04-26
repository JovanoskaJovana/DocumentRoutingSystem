package mk.ukim.finki.routingsystem.model.dto.Employee;

/**
 * DTO used for logging in the system.
 *
 * @param email       the email of the employee
 * @param password    the password of the employee
 * @param companyCode the company in which the employee works
 */
public record LoginRequestDto(
        String email,
        String password,
        String companyCode
) {
}
