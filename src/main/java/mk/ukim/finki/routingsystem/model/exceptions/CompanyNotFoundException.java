package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a company is not found with the given id.
 */

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException(String message) {
    super(message);
  }
}
