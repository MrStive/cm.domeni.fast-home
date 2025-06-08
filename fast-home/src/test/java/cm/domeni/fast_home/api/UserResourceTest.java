package cm.domeni.fast_home.api;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import cm.domeni.fast_home.dto.UserDTO;
import cm.domeni.fast_home.service.UserService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

@ExtendWith(MockitoExtension.class)
class UserResourceTest {
  @Mock private UserService userService;
  @InjectMocks private UserResource userResource;

  @Test
  void createUserTest() {
    UUID expectedId = UUID.randomUUID();
    UserDTO userDTO =
        new UserDTO()
            .firstName("John")
            .lastName("Doe")
            .email("john.doe@example.com")
            .phoneNumber("123-456-7890");

    when(userService.createUser(any(UserDTO.class))).thenReturn(expectedId);

    // spotless:off
    UUID createdId =
            given()
                    .standaloneSetup(new UserResource(userService))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(userDTO)
                    .when()
                    .post("/user")
                    .then()
                    .statusCode(201)
                    .extract().body().as(UUID.class);
    // spotless:on
    assertThat(createdId).isEqualTo(expectedId);
  }
}
