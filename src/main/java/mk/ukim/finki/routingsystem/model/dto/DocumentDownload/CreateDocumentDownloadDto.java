package mk.ukim.finki.routingsystem.model.dto.DocumentDownload;

import java.time.LocalDateTime;

/**
 * DTO for creating a new document download.
 *
 * @param documentId    the id of the document
 * @param documentTitle the title of the document
 * @param employeeId    the id of the employee that downloaded the document
 * @param versionId     the version of the document which is downloaded
 * @param downloadedAt  the date and time of the download
 */

public record CreateDocumentDownloadDto(
        Long documentId,
        String documentTitle,
        Long employeeId,
        Long versionId,
        LocalDateTime downloadedAt
) {
}
