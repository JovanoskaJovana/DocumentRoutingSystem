package mk.ukim.finki.routingsystem.model.dto.DocumentAction;

import java.time.LocalDateTime;

/**
 * DTO for displaying document action information.
 *
 * @param actionId            the id of the action
 * @param document            the title of the document
 * @param documentVersion     the version label of the document (e.g. "v1", "v2")
 * @param performedByEmployee the full name of the employee that performed the action
 * @param actionType          the type of the action
 * @param fromStatus          the document status before the action
 * @param toStatus            the document status after the action
 * @param note                a description of the performed action
 * @param dateTime            the date and time the action was performed
 */

public record DisplayDocumentActionDto(

        Long actionId,
        String document,
        String documentVersion,
        String performedByEmployee,
        String actionType,
        String fromStatus,
        String toStatus,
        String note,
        LocalDateTime dateTime

) {
}
