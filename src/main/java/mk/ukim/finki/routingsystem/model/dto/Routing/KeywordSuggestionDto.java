package mk.ukim.finki.routingsystem.model.dto.Routing;

/**
 * DTO that contains keyword suggestions for a department.
 *
 * @param word          the suggested keyword
 * @param count         the number of appearances in documents of the suggested keyword
 * @param departmentKey the key of the department to which are routed documents containing this keyword
 * @param message       the message for suggesting this keyword
 */

public record KeywordSuggestionDto(

        String word,
        Integer count,
        String departmentKey,
        String message
) {
}
