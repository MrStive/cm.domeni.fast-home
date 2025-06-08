package cm.domeni.fast_home.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import cm.domeni.fast_home.domain.building.Building;
import cm.domeni.fast_home.domain.building.BuildingAddress;
import cm.domeni.fast_home.domain.building.BuildingData;
import cm.domeni.fast_home.domain.building.BuildingId;
import cm.domeni.fast_home.domain.building.BuildingName;
import cm.domeni.fast_home.dto.BuildingDTO;
import cm.domeni.fast_home.dto.BuildingDTOAddress;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildingMapperTest {

  BuildingMapper objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new BuildingMapperImpl();
  }

  @Test
  void mapFromDTOToDataTest() {
    // Given
    var id = UUID.randomUUID();
    var name = "Building Name";
    var street = "123 Main St";
    var city = "New York";
    var zipCode = "10001";

    var buildingDTO =
        new BuildingDTO()
            .id(id)
            .name(name)
            .address(new BuildingDTOAddress().street(street).city(city).zipCode(zipCode));

    // When
    var data = objectUnderTest.map(buildingDTO);

    // Then
    assertThat(data)
        .isNotNull()
        .returns(id.toString(), BuildingData::id)
        .returns(name, BuildingData::name)
        .returns(street, BuildingData::street)
        .returns(city, BuildingData::city)
        .returns(zipCode, BuildingData::zipCode);
  }

  @Test
  void mapBuildingToDTOTest() {
    // Given
    var id = new BuildingId(UUID.randomUUID());
    var name = "Building Name";
    var street = "123 Main St";
    var city = "New York";
    var zipCode = "10001";

    var building =
        Building.builder()
            .id(id)
            .name(new BuildingName(name))
            .address(BuildingAddress.builder().street(street).city(city).zipCode(zipCode).build())
            .build();

    // When
    var dto = objectUnderTest.map(building);

    // Then
    assertThat(dto).isNotNull();
    assertThat(dto.getId()).isEqualTo(UUID.fromString(id.getValue()));
    assertThat(dto.getName()).isEqualTo(name);
    assertThat(dto.getAddress()).isNotNull();
    assertThat(dto.getAddress().getStreet()).isEqualTo(street);
    assertThat(dto.getAddress().getCity()).isEqualTo(city);
    assertThat(dto.getAddress().getZipCode()).isEqualTo(zipCode);
  }

  @Test
  void mapBuildingNameTest() {
    // Given
    var name = "Building Name";
    var buildingName = new BuildingName(name);

    // When
    var result = objectUnderTest.map(buildingName);

    // Then
    assertThat(result).isEqualTo(name);
  }

  @Test
  void mapBuildingNameNullTest() {
    // When
    var result = objectUnderTest.map((BuildingName) null);

    // Then
    assertThat(result).isNull();
  }

  @Test
  void mapBuildingIdTest() {
    // Given
    var uuid = UUID.randomUUID();
    var buildingId = new BuildingId(uuid);

    // When
    var result = objectUnderTest.map(buildingId);

    // Then
    assertThat(result).isEqualTo(uuid);
  }

  @Test
  void mapBuildingIdNullTest() {
    // When
    var result = objectUnderTest.map((BuildingId) null);

    // Then
    assertThat(result).isNull();
  }
}
