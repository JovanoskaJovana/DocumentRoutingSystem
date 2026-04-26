package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a department is not found with the given id.
 */

public class DepartmentNotFoundException extends RuntimeException {
  public DepartmentNotFoundException(String message) {
    super(message);
  }
}
