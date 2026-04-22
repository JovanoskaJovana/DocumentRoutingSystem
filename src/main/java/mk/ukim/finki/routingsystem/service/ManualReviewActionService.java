package mk.ukim.finki.routingsystem.service;

import mk.ukim.finki.routingsystem.model.dto.Routing.KeywordSuggestionDto;

import java.util.List;

/**
 * Service interface for managing {@link mk.ukim.finki.routingsystem.model.ManualReviewAction} entities.
 */

public interface ManualReviewActionService {

  /**
   * Lists the suggested keywords that should be added to a department's routing configuration within a company.
   *
   * @param companyId    the id of the given company
   * @param departmentId the id of the given department
   * @return list of {@link KeywordSuggestionDto} representing all suggested keywords for a department
   */
  List<KeywordSuggestionDto> suggestKeyword(Long companyId, Long departmentId);

  /**
   * Lists the suggested keywords that should be added to a department's routing configuration within a company.
   *
   * @param companyId the id of the given company
   * @return list of {@link KeywordSuggestionDto} representing all suggested keywords for all departments
   */
  List<KeywordSuggestionDto> suggestAllKeywords(Long companyId);

}
