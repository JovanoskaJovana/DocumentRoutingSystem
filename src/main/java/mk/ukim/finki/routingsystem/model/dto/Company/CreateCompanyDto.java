package mk.ukim.finki.routingsystem.model.dto.Company;

/**
 * DTO for creating a new company.
 *
 * @param name the name of the company
 * @param code the unique code identifying the company
 */

public record CreateCompanyDto(
        String name,
        String code

) {
}
