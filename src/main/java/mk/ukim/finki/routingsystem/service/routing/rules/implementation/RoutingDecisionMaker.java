package mk.ukim.finki.routingsystem.service.routing.rules.implementation;

import mk.ukim.finki.routingsystem.model.dto.Routing.RoutingDecision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Determines the routing decision based on keyword scores assigned to each department.
 * A document is automatically routed if a single department scores above the minimum
 * threshold and leads by a sufficient margin. Otherwise, manual review is required.
 */

public class RoutingDecisionMaker {

  private static final Integer MIN_THRESHOLD = 9;
  private static final Integer MIN_DIFFERENCE = 3;

  /**
   * Decides the routing outcome based on the given department scores.
   * A department is automatically selected if:
   *   Its score is above the minimum threshold of {@value MIN_THRESHOLD}
   *   It leads the second-best score by more than {@value MIN_DIFFERENCE}
   * Otherwise, manual review is triggered with the tied departments as candidates.
   *
   * @param scores a map of department keys to their computed keyword scores
   * @return a {@link RoutingDecision} containing the result of the routing decision
   */
  public RoutingDecision decide(Map<String, Double> scores) {

    double topScore = Collections.max(scores.values());

    if (topScore < MIN_THRESHOLD) {
      return new RoutingDecision(null, null, true, scores);
    }

    List<String> tied = new ArrayList<>();
    double secondBest = 0.0;

    for (Map.Entry<String, Double> entry : scores.entrySet()) {

      if (Math.abs(topScore - entry.getValue()) < 0.0001) {
        tied.add(entry.getKey());
      }

      if (entry.getValue() < topScore && entry.getValue() > secondBest) {
        secondBest = entry.getValue();
      }
    }

    if (tied.size() == 1 && (topScore - secondBest) > MIN_DIFFERENCE) {
      return new RoutingDecision(tied.getFirst(), null, false, scores);
    } else {
      return new RoutingDecision(null, tied, true, scores);
    }
  }

}
