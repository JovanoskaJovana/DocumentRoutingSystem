package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a required employee id is not provided.
 */

public class RequiredEmployeeIdException extends RuntimeException {
  public RequiredEmployeeIdException(String message) {
    super(message);
  }
}
