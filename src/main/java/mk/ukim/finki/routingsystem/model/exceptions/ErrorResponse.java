package mk.ukim.finki.routingsystem.model.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Custom ErrorResponse class that will explain the error to the user.
 */

@Getter
public class ErrorResponse {

  private final int status;
  private final String message;
  private final LocalDateTime timestamp = LocalDateTime.now();

  public ErrorResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

}
