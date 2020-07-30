package mmtr.inventory.repository;

import mmtr.inventory.model.db.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, UUID> {}
