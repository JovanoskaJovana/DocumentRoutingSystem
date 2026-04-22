package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a company already exists in the database.
 */

public class CompanyAlreadyExistsException extends RuntimeException {
  public CompanyAlreadyExistsException(String message) {
    super(message);
  }
}
