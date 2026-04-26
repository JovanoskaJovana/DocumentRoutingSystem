package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a document is not found with the given id.
 */

public class DocumentNotFoundException extends RuntimeException {
  public DocumentNotFoundException(String message) {
    super(message);
  }
}
