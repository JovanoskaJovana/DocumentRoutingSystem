package mk.ukim.finki.routingsystem.model.dto.Routing;

/**
 * DTO for separating the title and the body parts of a PDF document.
 *
 * @param title the title part of the document
 * @param body  the body part of the document
 */

public record TitleAndBody(
        String title,
        String body
) {
}
