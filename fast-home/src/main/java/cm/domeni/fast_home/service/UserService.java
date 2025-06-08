package cm.domeni.fast_home.service;

import cm.domeni.fast_home.domain.user.User;
import cm.domeni.fast_home.domain.user.UserFactory;
import cm.domeni.fast_home.domain.user.UserId;
import cm.domeni.fast_home.dto.UserDTO;
import cm.domeni.fast_home.service.mapper.UserMapper;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserFactory userFactory;
  private final UserMapper userMapper;

  @Transactional
  public UUID createUser(UserDTO data) {
    return Optional.ofNullable(data)
        .map(userMapper::map)
        .map(userFactory::create)
        .map(User::getId)
        .map(UserId::getValue)
        .map(UUID::fromString)
        .orElseThrow();
  }
}
