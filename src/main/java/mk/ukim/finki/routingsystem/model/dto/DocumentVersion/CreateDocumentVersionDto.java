package mk.ukim.finki.routingsystem.model.dto.DocumentVersion;

import java.time.LocalDateTime;

/**
 * DTO for creating a document version.
 *
 * @param documentId        the id of the document
 * @param versionNumber     the version number of the document
 * @param editedByEmployee  the id of the employee that edited the document
 * @param fileName          the name of the file
 * @param changeNote        a description of the changes that created the new version
 * @param uploadedDateTime  the date and time the new version was uploaded
 * @param fileData          the raw bytes of the document file
 */

public record CreateDocumentVersionDto(
        Long documentId,
        int versionNumber,
        Long editedByEmployee,
        String fileName,
        String changeNote,
        LocalDateTime uploadedDateTime,
        byte[] fileData
) {
}
