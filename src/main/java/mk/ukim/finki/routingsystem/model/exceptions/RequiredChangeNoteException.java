package mk.ukim.finki.routingsystem.model.exceptions;

/**
 * Thrown when a required change note is not provided.
 */

public class RequiredChangeNoteException extends RuntimeException {
  public RequiredChangeNoteException(String message) {
    super(message);
  }
}
