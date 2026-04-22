package mk.ukim.finki.routingsystem.model.dto;

/**
 * DTO for creating and displaying department information.
 *
 * @param id        the id of the department
 * @param name      the name of the department
 * @param key       the key of the department
 * @param companyId the company that the department belongs to
 */
public record CreateDisplayDepartmentDto(

        Long id,
        String name,
        String key,
        Long companyId
) {
}
