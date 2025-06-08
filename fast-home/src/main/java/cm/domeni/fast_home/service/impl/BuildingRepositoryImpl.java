package cm.domeni.fast_home.service.impl;

import cm.domeni.fast_home.domain.building.Building;
import cm.domeni.fast_home.domain.building.BuildingRepository;
import cm.domeni.fast_home.repository.BuildingSpringRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuildingRepositoryImpl implements BuildingRepository {
  private final BuildingSpringRepository buildingSpringRepository;

  @Override
  public Building save(Building value) {
    return buildingSpringRepository.save(value);
  }

  @Override
  public List<Building> findAll() {
    return new ArrayList<>(buildingSpringRepository.findAll());
  }
}
