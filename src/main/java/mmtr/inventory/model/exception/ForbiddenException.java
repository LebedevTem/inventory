package mmtr.inventory.model.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpError {
  public ForbiddenException(String message) {
    super(HttpStatus.FORBIDDEN, message);
  }

  public ForbiddenException() {
    this("Forbidden");
  }
}
