package mmtr.inventory.model.request;

import lombok.Data;
import mmtr.inventory.model.enums.EquipmentState;

import java.util.UUID;

@Data
public class EquipmentRequest {

  private UUID userId;
  private String name;
  private EquipmentState state;
  private String location;
  private String type;
}
