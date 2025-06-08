package cm.domeni.fast_home.domain.building.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import cm.domeni.fast_home.domain.building.*;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BuildingFactoryImplTest {
  @InjectMocks BuildingFactoryImpl objectUnderTest;
  @Mock BuildingRepository buildingRepository;

  @Test
  void createTest() {
    // Given
    String id = UUID.randomUUID().toString();
    String name = "Building Name";
    String street = "123 Main St";
    String city = "New York";
    String zipCode = "10001";

    BuildingData buildingData =
        BuildingData.builder().id(id).name(name).street(street).city(city).zipCode(zipCode).build();

    Building expected = mock(Building.class);
    given(buildingRepository.save(any())).willReturn(expected);

    // When
    Building result = objectUnderTest.create(buildingData);

    // Then
    verify(buildingRepository)
        .save(
            assertArg(
                building ->
                    assertThat(building)
                        .usingRecursiveComparison()
                        .ignoringFieldsOfTypes(BuildingId.class)
                        .isEqualTo(
                            Building.builder()
                                .name(new BuildingName(name))
                                .address(
                                    BuildingAddress.builder()
                                        .street(street)
                                        .city(city)
                                        .zipCode(zipCode)
                                        .build())
                                .build())));
    assertThat(result).isNotNull().isEqualTo(expected);
  }
}
