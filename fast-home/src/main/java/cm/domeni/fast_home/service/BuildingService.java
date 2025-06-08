package cm.domeni.fast_home.service;

import cm.domeni.fast_home.domain.building.Building;
import cm.domeni.fast_home.domain.building.BuildingFactory;
import cm.domeni.fast_home.domain.building.BuildingId;
import cm.domeni.fast_home.dto.BuildingDTO;
import cm.domeni.fast_home.service.mapper.BuildingMapper;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BuildingService {
  private final BuildingFactory buildingFactory;
  private final BuildingMapper buildingMapper;

  @Transactional
  public UUID createBuilding(BuildingDTO data) {
    return Optional.ofNullable(data)
        .map(buildingMapper::map)
        .map(buildingFactory::create)
        .map(Building::getId)
        .map(BuildingId::getValue)
        .map(UUID::fromString)
        .orElseThrow();
  }
}
