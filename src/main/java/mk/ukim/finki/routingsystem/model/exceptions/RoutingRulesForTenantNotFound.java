package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when the routing rules for a tenant are not provided.
 */

public class RoutingRulesForTenantNotFound extends RuntimeException {
  public RoutingRulesForTenantNotFound(String message) {
    super(message);
  }
}
