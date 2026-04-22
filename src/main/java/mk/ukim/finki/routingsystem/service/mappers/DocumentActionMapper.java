package mk.ukim.finki.routingsystem.service.mappers;

import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentAction;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.dto.DocumentAction.DisplayDocumentActionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

/**
 * MapStruct mapper for converting {@link DocumentAction} entities to DTOs.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentActionMapper {

  @Mapping(target = "actionId", source = "id")
  @Mapping(target = "document", source = "document.title")
  @Mapping(target = "actionType", source = "performedAction", qualifiedByName = "enumName")
  @Mapping(target = "note", source = "notes")
  @Mapping(target = "dateTime", source = "actionDateTime")
  @Mapping(target = "performedByEmployee", qualifiedByName = "fullName")
  @Mapping(target = "documentVersion", qualifiedByName = "versionLabel")
  DisplayDocumentActionDto toDto(DocumentAction documentAction);


  /**
   * Combines the first and last name of the employee.
   *
   * @param employee the given employee
   * @return the full name of the employee, or null if the object is null
   */
  @Named("fullName")
  default String fullName(Employee employee) {
    if (employee == null) {
      return null;
    }

    return (employee.getFirstName() + " " + employee.getLastName()).trim();
  }

  /**
   * Formats the version number of a document version as a label (e.g. "v1", "v2").
   *
   * @param documentVersion the given document version
   * @return the formatted version number of a document, or null if the document version is null or 0
   */
  @Named("versionLabel")
  default String versionLabel(DocumentVersion documentVersion) {
    if ((documentVersion == null) || ((documentVersion.getVersionNumber()) == 0)) {
      return null;
    }
    return "v" + documentVersion.getVersionNumber();
  }

  /**
   * Returns the name of an enum constant as a string.
   *
   * @param enumValue the given enum value
   * @return the name of the enum constant, or null if the enum value is null
   */
  @Named("enumName")
  default String enumName(Enum<?> enumValue) {

    return (enumValue == null) ? null : enumValue.name();
  }
}
