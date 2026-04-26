package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when the document status is invalid.
 */

public class InvalidDocumentStateException extends RuntimeException {
  public InvalidDocumentStateException(String message) {
    super(message);
  }
}
