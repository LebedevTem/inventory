package mmtr.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import mmtr.inventory.model.db.Equipment;
import mmtr.inventory.model.db.EquipmentType;
import mmtr.inventory.model.front.PageableResponse;
import mmtr.inventory.model.request.EquipmentRequest;
import mmtr.inventory.model.request.OffsetPageRequest;
import mmtr.inventory.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/equipments")
public class EquipmentController {

  private final EquipmentService equipmentService;

  // TODO добавить PageableResolver (HandlerMethodArgumentResolver)
  @GetMapping("/users/{id}")
  public PageableResponse<Equipment> getByUserId(
      @RequestParam(name = "limit", defaultValue = "25") int limit,
      @RequestParam(name = "offset", defaultValue = "0") long offset,
      @RequestParam(name = "sortDir") String sortDir,
      @RequestParam(name = "sortBy") String sortBy,
      @PathVariable(name = "id") UUID userId) {
    val pageRequest = new OffsetPageRequest(limit, offset, sortBy, sortDir);
    val equipments = equipmentService.getByUserId(userId, pageRequest);
    return new PageableResponse<>(equipments);
  }

  @GetMapping("/{id}")
  public Equipment getById(@PathVariable(name = "id") UUID equipmentId) {
    return equipmentService.getById(equipmentId);
  }

  @GetMapping("/types")
  public List<EquipmentType> getTypes(
      @RequestParam(name = "pageRequest") OffsetPageRequest pageRequest) {
    return equipmentService.getTypes(pageRequest);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Equipment createEquipment(@RequestBody EquipmentRequest request) {
    return equipmentService.createEquipment(request);
  }

  @PostMapping("/{id}")
  public Equipment updateEquipment(
      @PathVariable(name = "id") UUID equipmentId, @RequestBody EquipmentRequest request) {
    return equipmentService.updateEquipment(equipmentId, request);
  }

  @PostMapping("/{id}/decommission")
  public Equipment decommission(@PathVariable(name = "id") UUID equipmentId) {
    return equipmentService.decommission(equipmentId);
  }
}
