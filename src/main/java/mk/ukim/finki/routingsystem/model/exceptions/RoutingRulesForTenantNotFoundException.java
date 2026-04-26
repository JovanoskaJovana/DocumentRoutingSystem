package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when the routing rules for a tenant are not provided.
 */

public class RoutingRulesForTenantNotFoundException extends RuntimeException {
  public RoutingRulesForTenantNotFoundException(String message) {
    super(message);
  }
}
