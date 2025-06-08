package cm.domeni.fast_home.api;

import cm.domeni.fast_home.dto.UserDTO;
import cm.domeni.fast_home.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserResource implements UserApi {
  private final UserService userService;

  @Override
  public ResponseEntity<UUID> createUser(UserDTO userDTO) {
    UUID createdUserId = userService.createUser(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUserId);
  }
}
