package mmtr.inventory.model.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import mmtr.inventory.model.enums.EquipmentState;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "equipment")
@Data
@NoArgsConstructor
public class Equipment {

  @Id private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "name")
  private String name;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private EquipmentState state;

  @Column(name = "commissioning_date")
  private OffsetDateTime commissioningDate;

  @Column(name = "decommissioning_date")
  private OffsetDateTime decommissioningDate;

  @Column(name = "location")
  private String location;

  @Column(name = "type")
  private String type;
}
