package mk.ukim.finki.routingsystem.events;

import java.time.LocalDateTime;

/**
 * Event published when a document download is requested.
 */

public record DocumentDownloadRequestedEvent(
        Long documentId,
        String documentTitle,
        Long employeeId,
        Long versionId,
        LocalDateTime downloadedAt
) {
}
