package mmtr.inventory.repository;

import mmtr.inventory.model.db.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.UUID;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {

  Page<Equipment> findAllByUserId(UUID id, Pageable pageable);

  @Modifying
  @Transactional
  @Query("update Equipment e set e.decommissioningDate = ?2 where e.id = ?1")
  void decommission(UUID equipmentId, OffsetDateTime date);
}
