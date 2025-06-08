package cm.domeni.fast_home.domain.building.impl;

import cm.domeni.fast_home.domain.building.*;
import cm.domeni.fast_home.domain.user.UserId;
import cm.domeni.fast_home.domain.user.UserRepository;
import java.util.HashSet;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuildingFactoryImpl implements BuildingFactory {
  private final BuildingRepository buildingRepository;
  private final UserRepository userRepository;

  @Override
  public Building create(BuildingData buildingData) {
    Building building =
        Building.builder()
            .name(new BuildingName(buildingData.name()))
            .address(
                BuildingAddress.builder()
                    .street(buildingData.street())
                    .city(buildingData.city())
                    .zipCode(buildingData.zipCode())
                    .build())
            .location(
                buildingData.latitude() != null && buildingData.longitude() != null
                    ? BuildingLocation.builder()
                        .latitude(buildingData.latitude())
                        .longitude(buildingData.longitude())
                        .build()
                    : null)
            .totalArea(buildingData.totalArea())
            .floors(buildingData.floors())
            .reference(buildingData.reference())
            .amenities(
                buildingData.amenities() != null
                    ? new HashSet<>(buildingData.amenities())
                    : new HashSet<>())
            .build();

    // Set owner if ownerId is provided
    if (buildingData.ownerId() != null) {
      try {
        UUID ownerUuid = UUID.fromString(buildingData.ownerId());
        UserId ownerId = new UserId(ownerUuid);
        userRepository.findById(ownerId).ifPresent(building::setOwner);
      } catch (IllegalArgumentException e) {
        // Invalid UUID format, ignore
      }
    }

    return buildingRepository.save(building);
  }
}
