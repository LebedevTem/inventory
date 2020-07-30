package mmtr.inventory.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum UserRole {
  ROLE_ADMIN("role_admin"),
  ROLE_USER("role_user");

  @JsonValue private final String code;

  @JsonCreator
  public static EquipmentState fromString(String wanted) {
    return Stream.of(EquipmentState.values())
        .filter(type -> type.name().equalsIgnoreCase(wanted))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Invalid role: " + wanted));
  }
}
