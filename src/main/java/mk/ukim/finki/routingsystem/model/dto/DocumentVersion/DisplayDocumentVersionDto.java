package mk.ukim.finki.routingsystem.model.dto.DocumentVersion;

import java.time.LocalDateTime;

/**
 * DTO for displaying document version information.
 *
 * @param versionId          the id of the version
 * @param document           the title of the document
 * @param versionNumber      the version label of the document (e.g. "v1", "v2")
 * @param fileName           the name of the file
 * @param uploadedByEmployee the full name of the employee that created the version
 * @param changeNote         a description of the changes that created the new version
 * @param uploadedDateTime   the date and time the new version was uploaded
 * @param downloadUrl        url for downloading the appropriate version
 */

public record DisplayDocumentVersionDto(

        Long versionId,
        String document,
        String versionNumber,
        String fileName,
        String uploadedByEmployee,
        String changeNote,
        LocalDateTime uploadedDateTime,
        String downloadUrl

) {
}
