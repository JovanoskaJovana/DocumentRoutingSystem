package mk.ukim.finki.routingsystem.service.mappers;

import mk.ukim.finki.routingsystem.model.Employee;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.dto.DocumentVersion.DisplayDocumentVersionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

/**
 * MapStruct mapper for converting {@link DocumentVersion} entities to DTOs.
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentVersionMapper {

  @Mapping(target = "versionId", source = "id")
  @Mapping(target = "document", source = "document.title")
  @Mapping(target = "versionNumber", qualifiedByName = "versionLabel")
  @Mapping(target = "uploadedByEmployee", qualifiedByName = "fullName")
  @Mapping(target = "fileName", source = "fileName")
  @Mapping(target = "downloadUrl", source = "documentVersion", qualifiedByName = "downloadUrl")
  DisplayDocumentVersionDto toDto(DocumentVersion documentVersion);

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
  default String versionLabel(int documentVersion) {
    if (documentVersion == 0) {
      return null;
    }
    return "v" + documentVersion;
  }

  /**
   * Builds the download URL for a given document version in the format
   * /api/documents/{documentId}/versions/{versionId}/download.
   *
   * @param documentVersion the given document version
   * @return the formatted download URL, or null if the version or its id is null
   */
  @Named("downloadUrl")
  default String downloadUrl(DocumentVersion documentVersion) {
    if (documentVersion == null || documentVersion.getId() == null) {
      return null;
    }

    Long documentId = documentVersion.getDocument() != null ? documentVersion.getDocument().getId() : null;

    return "/api/documents/" + documentId + "/versions/" + documentVersion.getId() + "/download";
  }

}
