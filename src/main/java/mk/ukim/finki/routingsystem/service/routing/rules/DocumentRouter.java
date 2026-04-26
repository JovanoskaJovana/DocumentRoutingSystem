package mk.ukim.finki.routingsystem.service.routing.rules;

import mk.ukim.finki.routingsystem.model.dto.Routing.RoutingDecision;
import mk.ukim.finki.routingsystem.model.dto.Routing.TitleAndBody;

/**
 * Service interface for routing documents to the correct department based on their content.
 */

public interface DocumentRouter {

  /**
   * Routes a document to the appropriate department based on keyword scoring.
   *
   * @param tenantName the code identifying the tenant whose routing rules are used
   * @param document   the extracted title and body of the document to route
   * @return a {@link RoutingDecision} containing the result of the routing decision
   */
  RoutingDecision route(String tenantName, TitleAndBody document);

}
