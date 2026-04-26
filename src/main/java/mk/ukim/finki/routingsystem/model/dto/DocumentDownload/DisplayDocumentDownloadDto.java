package mk.ukim.finki.routingsystem.model.dto.DocumentDownload;

import java.time.LocalDateTime;

/**
 * DTO for displaying document download information.
 *
 * @param downloadId    the id of the download
 * @param documentTitle the title of the document
 * @param employee      the full name of the employee that downloaded the document
 * @param versionNumber the version label of the document (e.g. "v1", "v2")
 * @param downloadedAt  the date and time of the download
 */

public record DisplayDocumentDownloadDto(
        Long downloadId,
        String documentTitle,
        String employee,
        String versionNumber,
        LocalDateTime downloadedAt
) {
}
