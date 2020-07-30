package mmtr.inventory.model.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpError {

  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }

  public NotFoundException() {
    this("No such object found");
  }
}
