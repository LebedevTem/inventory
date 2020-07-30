package mmtr.inventory.model.request;

import lombok.Data;
import mmtr.inventory.model.enums.UserRole;

@Data
public class UserRequest {

  private String name;
  private UserRole role;
}
