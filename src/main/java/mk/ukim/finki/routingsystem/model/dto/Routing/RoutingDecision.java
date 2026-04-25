package mk.ukim.finki.routingsystem.model.dto.Routing;

import java.util.List;
import java.util.Map;

/**
 * DTO representing the outcome of a document routing decision.
 *
 * @param winner               the key of the department the document is routed to, or null if manual review is required
 * @param selectedDepartments  the list of department keys that are tied or have difference between 0 & 1, or null if there is a clear winner
 * @param requiresManualReview whether the document requires manual routing review
 * @param scores               a map of department keys to their computed keyword scores
 */

public record RoutingDecision(
        String winner,
        List<String> selectedDepartments,
        boolean requiresManualReview,
        Map<String, Double> scores
) {
}
