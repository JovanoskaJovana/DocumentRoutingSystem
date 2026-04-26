package mk.ukim.finki.routingsystem.service.routing.text;

import mk.ukim.finki.routingsystem.model.dto.Routing.TitleAndBody;

/**
 * Service interface for extracting the text from the uploaded PDF document.
 */

public interface DocumentTextExtractor {

  /**
   * Extracts all text from a PDF document.
   *
   * @param text the raw bytes of the PDF document
   * @return a string containing the full text of the document
   */
  String extractAll(byte[] text);

  /**
   * Extracts the text from a PDF document in a title and body.
   *
   * @param text the raw bytes of the PDF document
   * @return a {@link TitleAndBody} containing the title and body of the document
   */
  TitleAndBody extractTitleAndBody(byte[] text);

}
