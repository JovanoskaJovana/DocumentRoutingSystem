package mk.ukim.finki.routingsystem.model.dto.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for displaying document information.
 *
 * @param documentId                the id of the document
 * @param title                     the title of the document
 * @param uploadedByEmployee        the full name of the employee that uploaded the document
 * @param routedToEmployees         the employees to which the document is routed to
 * @param uploadedDateTime          the upload date and time
 * @param documentStatus            the status of the document
 * @param currentVersion            the version label of the document (e.g. "v1", "v2")
 * @param currentVersionDownloadUrl the download url for the current version
 */

public record DisplayDocumentDto(

        Long documentId,
        String title,
        String uploadedByEmployee,
        List<String> routedToEmployees,
        LocalDateTime uploadedDateTime,
        String documentStatus,
        String currentVersion,
        String currentVersionDownloadUrl

) {
}
