package mk.ukim.finki.routingsystem.service.mappers;

import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentDownload;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

/**
 * MapStruct mapper for converting {@link DocumentDownload} entities to DTOs.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentDownloadMapper {

  @Mapping(target = "downloadId", source = "id")
  @Mapping(target = "documentTitle", source = "document.title")
  @Mapping(target = "employee", qualifiedByName = "fullName")
  @Mapping(target = "versionNumber", source = "documentVersion", qualifiedByName = "versionLabel")
  @Mapping(target = "downloadedAt", source = "downloadDateTime")
  DisplayDocumentDownloadDto toDto(DocumentDownload documentDownload);

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
    return employee.getFirstName() + " " + employee.getLastName();
  }

  /**
   * Formats the version number of a document version as a label (e.g. "v1", "v2").
   *
   * @param documentVersion the given document version
   * @return the formatted version number of a document, or null if the document version is null or 0
   */
  @Named("versionLabel")
  default String versionLabel(DocumentVersion documentVersion) {
    if (documentVersion == null || documentVersion.getVersionNumber() == 0) {
      return null;
    }
    return "v" + documentVersion.getVersionNumber();
  }
}
