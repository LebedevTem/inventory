package mmtr.inventory.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum EquipmentState {
  ISSUED("issued"),
  IN_STOCK("in_stock");

  @JsonValue private final String code;

  @JsonCreator
  public static EquipmentState fromString(String wanted) {
    return Stream.of(EquipmentState.values())
        .filter(type -> type.name().equalsIgnoreCase(wanted))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Invalid state name: " + wanted));
  }
}
