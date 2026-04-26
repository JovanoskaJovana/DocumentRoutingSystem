package mk.ukim.finki.routingsystem.domain.rules;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Domain representation of routing rules for a single tenant, containing the admin department key and routing rules per department.
 */
@Getter
@Setter
public class TenantRules {

    private String adminDeptId;

    private Map<String, DepartmentRules> departments;

}
