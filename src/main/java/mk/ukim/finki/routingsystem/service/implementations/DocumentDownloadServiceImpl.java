package mk.ukim.finki.routingsystem.service.implementations;

import mk.ukim.finki.routingsystem.events.DocumentActionRequestedEvent;
import mk.ukim.finki.routingsystem.events.DocumentDownloadRequestedEvent;
import mk.ukim.finki.routingsystem.model.documentEntities.DocumentVersion;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.FileResource;
import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.PreparedDocumentDownload;
import mk.ukim.finki.routingsystem.model.enumerations.ActionType;
import mk.ukim.finki.routingsystem.model.enumerations.DocumentStatus;
import mk.ukim.finki.routingsystem.model.exceptions.DocumentVersionNotFoundException;
import mk.ukim.finki.routingsystem.repository.DocumentDownloadRepository;
import mk.ukim.finki.routingsystem.repository.DocumentVersionRepository;
import mk.ukim.finki.routingsystem.service.DocumentDownloadService;
import mk.ukim.finki.routingsystem.service.LoadingFileService;
import mk.ukim.finki.routingsystem.service.mappers.DocumentDownloadMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of {@link DocumentDownloadService}
 */

@Service
public class DocumentDownloadServiceImpl implements DocumentDownloadService {

  public final DocumentDownloadRepository documentDownloadRepository;
  private final DocumentDownloadMapper documentDownloadMapper;
  private final LoadingFileService fileService;
  private final ApplicationEventPublisher applicationEventPublisher;
  private final DocumentVersionRepository documentVersionRepository;

  public DocumentDownloadServiceImpl(DocumentDownloadRepository documentDownloadRepository, DocumentDownloadMapper documentDownloadMapper, LoadingFileService fileService, ApplicationEventPublisher applicationEventPublisher, DocumentVersionRepository documentVersionRepository) {
    this.documentDownloadRepository = documentDownloadRepository;
    this.documentDownloadMapper = documentDownloadMapper;
    this.fileService = fileService;
    this.applicationEventPublisher = applicationEventPublisher;
    this.documentVersionRepository = documentVersionRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<DisplayDocumentDownloadDto> findAllDownloadsByEmployee(Long employeeId, Long companyId) {
    return documentDownloadRepository.findAllByEmployee_IdAndDocument_Company_IdOrderByDownloadDateTimeDesc(employeeId, companyId)
            .stream().map(documentDownloadMapper::toDto).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<DisplayDocumentDownloadDto> findAllDownloadsByDocument(Long documentId, Long companyId) {
    return documentDownloadRepository.findAllByDocument_IdAndDocument_Company_Id(documentId, companyId)
            .stream().map(documentDownloadMapper::toDto).toList();
  }

  @Override
  @Transactional
  public PreparedDocumentDownload prepareDownload(Long documentId, Long versionId, Long companyId, Long employeeId) {

    DocumentVersion documentVersion = documentVersionRepository.findById(versionId)
            .orElseThrow(() -> new DocumentVersionNotFoundException("Document version not found."));

    if (!documentVersion.getDocument().getId().equals(documentId)) {
      throw new DocumentVersionNotFoundException("Version does not belong to this document.");
    }

    FileResource file = fileService.loadFile(documentId, versionId, companyId);

    if (file == null || file.length() == 0) {
      return null;
    }

    String title = documentVersion.getDocument().getTitle().trim();

    applicationEventPublisher.publishEvent(
            new DocumentDownloadRequestedEvent(
                    documentId,
                    title,
                    employeeId,
                    versionId,
                    LocalDateTime.now())
    );

    applicationEventPublisher.publishEvent(new DocumentActionRequestedEvent(
            documentVersion.getDocument().getId(),
            documentVersion.getId(),
            employeeId,
            ActionType.DOWNLOADED,
            documentVersion.getDocument().getDocumentStatus(),
            DocumentStatus.DOWNLOADED,
            LocalDateTime.now()
    ));

    String fileName = documentVersion.getFileName() != null ? documentVersion.getFileName() : "document-" + versionId + ".pdf";

    return new PreparedDocumentDownload(file, fileName);
  }

}
