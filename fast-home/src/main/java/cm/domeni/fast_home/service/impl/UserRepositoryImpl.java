package cm.domeni.fast_home.service.impl;

import cm.domeni.fast_home.domain.user.User;
import cm.domeni.fast_home.domain.user.UserId;
import cm.domeni.fast_home.domain.user.UserRepository;
import cm.domeni.fast_home.repository.UserSpringRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserRepositoryImpl implements UserRepository {
  private final UserSpringRepository userSpringRepository;

  @Override
  public User save(User value) {
    return userSpringRepository.save(value);
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(userSpringRepository.findAll());
  }

  @Override
  public Optional<User> findById(UserId id) {
    return userSpringRepository.findById(id);
  }
}
