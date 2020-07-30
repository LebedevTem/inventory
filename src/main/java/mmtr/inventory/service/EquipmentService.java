package mmtr.inventory.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import mmtr.inventory.model.db.Equipment;
import mmtr.inventory.model.db.EquipmentType;
import mmtr.inventory.model.exception.NotFoundException;
import mmtr.inventory.model.request.EquipmentRequest;
import mmtr.inventory.repository.EquipmentRepository;
import mmtr.inventory.repository.EquipmentTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentService {

  private final EquipmentRepository equipmentRepository;
  private final EquipmentTypeRepository equipmentTypeRepository;
  private final UserService userService;

  public Page<Equipment> getByUserId(UUID userId, Pageable pageable) {
    return equipmentRepository.findAllByUserId(userId, pageable);
  }

  public Equipment getById(UUID id) {
    return equipmentRepository.findById(id).orElseThrow(NotFoundException::new);
  }

  public List<EquipmentType> getTypes(Pageable pageable) {
    return equipmentTypeRepository.findAll();
  }

  public Equipment createEquipment(EquipmentRequest request) {
    userService.throwForbiddenIfNotAdmin();
    val equipment = new Equipment();
    equipment.setId(UUID.randomUUID());
    equipment.setUserId(request.getUserId());
    equipment.setName(request.getName());
    equipment.setState(request.getState());
    equipment.setCommissioningDate(OffsetDateTime.now());
    equipment.setLocation(request.getLocation());
    equipment.setType(request.getType());
    return equipmentRepository.save(equipment);
  }

  public Equipment updateEquipment(UUID equipmentId, EquipmentRequest request) {
    userService.throwForbiddenIfNotAdmin();
    val equipment = getById(equipmentId);
    equipment.setUserId(request.getUserId());
    equipment.setState(request.getState());
    equipment.setLocation(request.getLocation());
    equipment.setType(request.getType());
    return equipmentRepository.save(equipment);
  }

  public Equipment decommission(UUID equipmentId) {
    userService.throwForbiddenIfNotAdmin();
    val equipment = getById(equipmentId);
    equipment.setDecommissioningDate(OffsetDateTime.now());
    return equipmentRepository.save(equipment);
  }
}
