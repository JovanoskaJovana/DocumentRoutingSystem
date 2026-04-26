package mk.ukim.finki.routingsystem.service.implementations;

import mk.ukim.finki.routingsystem.model.dto.DocumentAction.DisplayDocumentActionDto;
import mk.ukim.finki.routingsystem.repository.DocumentActionRepository;
import mk.ukim.finki.routingsystem.service.DocumentActionService;
import mk.ukim.finki.routingsystem.service.mappers.DocumentActionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link DocumentActionService}
 */

@Service
public class DocumentActionServiceImpl implements DocumentActionService {

  private final DocumentActionRepository documentActionRepository;
  private final DocumentActionMapper documentActionMapper;

  public DocumentActionServiceImpl(DocumentActionRepository documentActionRepository, DocumentActionMapper documentActionMapper) {
    this.documentActionRepository = documentActionRepository;
    this.documentActionMapper = documentActionMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<DisplayDocumentActionDto> findAllForADocument(Long documentId, Long companyId) {
    return documentActionRepository.findByDocument_IdAndDocument_Company_IdOrderByActionDateTime(documentId, companyId)
            .stream().map(documentActionMapper::toDto).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<DisplayDocumentActionDto> findAllBySpecificEmployee(Long documentId, Long employeeId, Long companyId) {
    return documentActionRepository.findByDocument_IdAndPerformedByEmployee_IdAndDocument_Company_IdOrderByActionDateTime(documentId, employeeId, companyId)
            .stream().map(documentActionMapper::toDto).toList();
  }
}
