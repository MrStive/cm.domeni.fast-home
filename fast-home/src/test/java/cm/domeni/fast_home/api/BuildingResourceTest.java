package cm.domeni.fast_home.api;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import cm.domeni.fast_home.dto.BuildingDTO;
import cm.domeni.fast_home.dto.BuildingDTOAddress;
import cm.domeni.fast_home.service.BuildingService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

@ExtendWith(MockitoExtension.class)
class BuildingResourceTest {
  @Mock private BuildingService buildingService;
  @InjectMocks private BuildingResource buildingResource;

  @Test
  void createBuildingTest() {
    UUID expectedId = UUID.randomUUID();
    BuildingDTO buildingDTO =
        new BuildingDTO()
            .name("Test Building")
            .address(
                new BuildingDTOAddress().street("123 Main St").city("New York").zipCode("10001"));

    when(buildingService.createBuilding(any(BuildingDTO.class))).thenReturn(expectedId);

    // spotless:off
    UUID createdId =
            given()
                    .standaloneSetup(new BuildingResource(buildingService))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(buildingDTO)
                    .when()
                    .post("/Building")
                    .then()
                    .statusCode(201)
                    .extract().body().as(UUID.class);
    // spotless:on
    assertThat(createdId).isEqualTo(expectedId);
  }
}
