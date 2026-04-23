package mk.ukim.finki.routingsystem.web;

import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.PreparedDocumentDownload;
import mk.ukim.finki.routingsystem.security.EmployeePrincipal;
import mk.ukim.finki.routingsystem.service.DocumentDownloadService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing document downloads.
 */

@RestController
@RequestMapping("/api/documents")
public class DocumentDownloadRestController {

  private final DocumentDownloadService documentDownloadService;

  public DocumentDownloadRestController(DocumentDownloadService documentDownloadService) {
    this.documentDownloadService = documentDownloadService;
  }

  @GetMapping("{documentId}/versions/{versionId}/download")
  public ResponseEntity<Resource> downloadPdf(@PathVariable Long documentId,
                                              @PathVariable Long versionId,
                                              @AuthenticationPrincipal EmployeePrincipal employeePrincipal) {

    PreparedDocumentDownload prepareDownload = documentDownloadService.prepareDownload(documentId, versionId, employeePrincipal.companyId(), employeePrincipal.employeeId());


    if (prepareDownload.file() == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok()
            .contentLength(prepareDownload.file().length())
            .contentType(prepareDownload.file().mediaType() != null ? prepareDownload.file().mediaType() : MediaType.APPLICATION_PDF)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + prepareDownload.filename() + "\"")
            .body(prepareDownload.file().resource());

  }

  @GetMapping("/{documentId}/documentDownloads")
  public ResponseEntity<List<DisplayDocumentDownloadDto>> getDownloadsByDocument(@PathVariable Long documentId,
                                                                                 @AuthenticationPrincipal EmployeePrincipal employeePrincipal) {

    return ResponseEntity.ok(documentDownloadService.findAllDownloadsByDocument(documentId, employeePrincipal.companyId()));

  }

  @GetMapping("/downloadsByMe")
  public ResponseEntity<List<DisplayDocumentDownloadDto>> getDownloadsByEmployee(@AuthenticationPrincipal EmployeePrincipal employeePrincipal) {

    return ResponseEntity.ok(documentDownloadService.findAllDownloadsByEmployee(employeePrincipal.employeeId(), employeePrincipal.companyId()));

  }

}
