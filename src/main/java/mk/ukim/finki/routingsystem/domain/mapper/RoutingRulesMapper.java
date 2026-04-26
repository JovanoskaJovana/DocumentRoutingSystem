package mk.ukim.finki.routingsystem.domain.mapper;

import mk.ukim.finki.routingsystem.config.DepartmentProperties;
import mk.ukim.finki.routingsystem.config.RoutingTenantProperties;
import mk.ukim.finki.routingsystem.domain.rules.RoutingRules;
import mk.ukim.finki.routingsystem.domain.rules.DepartmentRules;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * MapStruct mapper for converting routing configuration properties to domain rule objects.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoutingRulesMapper {

  DepartmentRules toDomain(DepartmentProperties departmentProperties);

  RoutingRules toDomain(RoutingTenantProperties routingTenantProperties);

}
