package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a document version is not found with the given id
 */

public class DocumentVersionNotFoundException extends RuntimeException {
  public DocumentVersionNotFoundException(String message) {
    super(message);
  }
}
