package mk.ukim.finki.routingsystem.config;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Configuration properties for a single tenant, containing the admin department key and routing rules per department.
 */

@Getter
@Setter
public class TenantProperties {

  private String adminDeptKey;

  private Map<String, DepartmentProperties> departments;

}
