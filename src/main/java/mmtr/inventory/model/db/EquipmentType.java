package mmtr.inventory.model.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "equipment_type")
public class EquipmentType {

  @Id private String type;
}
