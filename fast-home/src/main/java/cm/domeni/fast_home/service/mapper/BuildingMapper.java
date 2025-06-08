package cm.domeni.fast_home.service.mapper;

import cm.domeni.fast_home.domain.building.Building;
import cm.domeni.fast_home.domain.building.BuildingData;
import cm.domeni.fast_home.domain.building.BuildingId;
import cm.domeni.fast_home.domain.building.BuildingName;
import cm.domeni.fast_home.domain.user.UserId;
import cm.domeni.fast_home.dto.BuildingDTO;
import java.util.Optional;
import java.util.UUID;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    uses = {
      IdsMapper.class,
    },
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BuildingMapper {

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "name", source = "name")
  @Mapping(target = "id", source = "id")
  @Mapping(target = "street", source = "address.street")
  @Mapping(target = "city", source = "address.city")
  @Mapping(target = "zipCode", source = "address.zipCode")
  @Mapping(target = "latitude", source = "location.latitude")
  @Mapping(target = "longitude", source = "location.longitude")
  @Mapping(target = "totalArea", source = "totalArea")
  @Mapping(target = "floors", source = "floors")
  @Mapping(target = "ownerId", source = "ownerId")
  @Mapping(target = "reference", source = "reference")
  @Mapping(target = "amenities", source = "amenities")
  BuildingData map(BuildingDTO buildingDTO);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "address.street", source = "address.street")
  @Mapping(target = "address.city", source = "address.city")
  @Mapping(target = "address.zipCode", source = "address.zipCode")
  @Mapping(target = "location.latitude", source = "location.latitude")
  @Mapping(target = "location.longitude", source = "location.longitude")
  @Mapping(target = "totalArea", source = "totalArea")
  @Mapping(target = "floors", source = "floors")
  @Mapping(target = "ownerId", source = "owner.id")
  @Mapping(target = "reference", source = "reference")
  @Mapping(target = "amenities", source = "amenities")
  BuildingDTO map(Building building);

  default String map(BuildingName value) {
    return Optional.ofNullable(value).map(BuildingName::getValue).orElse(null);
  }

  default UUID map(BuildingId value) {
    return Optional.ofNullable(value).map(BuildingId::getValue).map(UUID::fromString).orElse(null);
  }

  default UUID map(UserId value) {
    return Optional.ofNullable(value).map(UserId::getValue).map(UUID::fromString).orElse(null);
  }
}
