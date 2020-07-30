package mmtr.inventory.model.db;

import lombok.Data;
import mmtr.inventory.model.enums.UserRole;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "inventory_user")
@Data
public class User {

  @Id private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private UserRole role;
}
