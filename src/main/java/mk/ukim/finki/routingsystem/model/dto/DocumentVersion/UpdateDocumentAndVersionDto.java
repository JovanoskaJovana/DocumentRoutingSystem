package mk.ukim.finki.routingsystem.model.dto.DocumentVersion;

/**
 * DTO for updating a document version.
 *
 * @param title              the title of the document
 * @param editedByEmployeeId the id of the employee which edited the document
 * @param changeNote         a description of the changes that created the new version
 * @param fileData           the raw bytes of the document file
 */
public record UpdateDocumentAndVersionDto(
        String title,
        Long editedByEmployeeId,
        String changeNote,
        byte[] fileData
) {
}
