package mk.ukim.finki.routingsystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Configuration properties for routing rules, loaded from the "app.routing" prefix.
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "app.routing")
public class RoutingTenantProperties {

  private Map<String, TenantProperties> tenants;

}
