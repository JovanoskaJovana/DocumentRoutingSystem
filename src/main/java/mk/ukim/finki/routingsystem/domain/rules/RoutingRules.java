package mk.ukim.finki.routingsystem.domain.rules;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Domain representation of routing rules containing the tenant name and tenant rules.
 */
@Getter
@Setter
public class RoutingRules {

  private Map<String, TenantRules> tenants;

}
