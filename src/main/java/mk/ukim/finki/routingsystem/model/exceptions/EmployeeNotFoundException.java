package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when an employee is not found with the given id.
 */

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
