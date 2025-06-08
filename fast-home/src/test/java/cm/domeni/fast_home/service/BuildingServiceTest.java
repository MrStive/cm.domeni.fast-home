package cm.domeni.fast_home.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import cm.domeni.fast_home.domain.building.*;
import cm.domeni.fast_home.dto.BuildingDTO;
import cm.domeni.fast_home.service.mapper.BuildingMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {

  @InjectMocks BuildingService objectUnderTest;

  @Mock BuildingFactory buildingFactory;
  @Mock BuildingMapper buildingMapper;

  @Test
  void shouldMapToDataObjectAndUseTheFactoryWhenAskedForNewBuildingCreation() {
    // Given
    var buildingDTO = mock(BuildingDTO.class);
    var expected = UUID.randomUUID();

    var buildingData = mock(BuildingData.class);
    given(buildingMapper.map(buildingDTO)).willReturn(buildingData);

    var building = mock(Building.class);
    given(building.getId()).willReturn(new BuildingId(expected));
    given(buildingFactory.create(buildingData)).willReturn(building);

    // When
    var id = objectUnderTest.createBuilding(buildingDTO);

    // Then
    assertThat(id).isNotNull().isEqualTo(expected);
  }
}
