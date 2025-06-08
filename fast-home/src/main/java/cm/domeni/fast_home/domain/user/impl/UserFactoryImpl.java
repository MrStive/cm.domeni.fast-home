package cm.domeni.fast_home.domain.user.impl;

import cm.domeni.fast_home.domain.user.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFactoryImpl implements UserFactory {
  private final UserRepository userRepository;

  @Override
  public User create(UserData userData) {
    return userRepository.save(
        User.builder()
            .firstName(userData.firstName())
            .lastName(userData.lastName())
            .email(userData.email())
            .phoneNumber(userData.phoneNumber())
            .build());
  }
}
