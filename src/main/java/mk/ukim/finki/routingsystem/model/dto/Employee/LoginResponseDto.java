package mk.ukim.finki.routingsystem.model.dto.Employee;

/**
 * DTO for response after logging in the system.
 *
 * @param token JWT token sent to the employee
 */

public record LoginResponseDto(
        String token
) {
}
