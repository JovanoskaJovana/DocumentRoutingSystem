package mk.ukim.finki.routingsystem.model.dto.Document;

/**
 * DTO for creating a new document.
 *
 * @param title the title of the document
 */

public record CreateDocumentDto(
        String title
) {
}
