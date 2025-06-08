package cm.domeni.fast_home.api;

import cm.domeni.fast_home.dto.BuildingDTO;
import cm.domeni.fast_home.service.BuildingService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BuildingResource implements BuildingApi {
  private final BuildingService buildingService;

  @Override
  public ResponseEntity<UUID> createBuilding(BuildingDTO buildingDTO) {
    UUID createdBuildingId = buildingService.createBuilding(buildingDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdBuildingId);
  }
}
