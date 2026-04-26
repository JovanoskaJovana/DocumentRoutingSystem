package mk.ukim.finki.routingsystem.model.dto.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for displaying document information for Admin employee.
 *
 * @param documentId                the id of the document
 * @param title                     the title of the document
 * @param uploadedByEmployee        the employee that uploaded the document
 * @param routedToDepartment        the department to which the document is routed to
 * @param routedToEmployees         the employees to which the document is routed to
 * @param uploadedDateTime          the upload date and time
 * @param documentStatus            the status of the document
 * @param currentVersion            the current version of the document
 * @param currentVersionDownloadUrl the download url for the current version
 */

public record DisplayAdminDocumentDto(

        Long documentId,
        String title,
        String uploadedByEmployee,
        String routedToDepartment,
        List<String> routedToEmployees,
        LocalDateTime uploadedDateTime,
        String documentStatus,
        String currentVersion,
        String currentVersionDownloadUrl
) {
}
