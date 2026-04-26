package mk.ukim.finki.routingsystem.model.dto.Company;

/**
 * DTO for displaying company information.
 *
 * @param name   the name of the company
 * @param code   the unique code identifying the company
 * @param active whether the company is currently active
 */

public record ResponseCompanyDto(
        String name,
        String code,
        Boolean active
) {
}
