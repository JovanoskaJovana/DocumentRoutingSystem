package mk.ukim.finki.routingsystem.service.implementations;

import mk.ukim.finki.routingsystem.model.dto.DocumentDownload.DisplayDocumentDownloadDto;
import mk.ukim.finki.routingsystem.repository.DocumentDownloadRepository;
import mk.ukim.finki.routingsystem.service.DocumentDownloadService;
import mk.ukim.finki.routingsystem.service.mappers.DocumentDownloadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link DocumentDownloadService}
 */

@Service
public class DocumentDownloadServiceImpl implements DocumentDownloadService {

  public final DocumentDownloadRepository documentDownloadRepository;
  private final DocumentDownloadMapper documentDownloadMapper;

  public DocumentDownloadServiceImpl(DocumentDownloadRepository documentDownloadRepository, DocumentDownloadMapper documentDownloadMapper) {
    this.documentDownloadRepository = documentDownloadRepository;
    this.documentDownloadMapper = documentDownloadMapper;
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

}
