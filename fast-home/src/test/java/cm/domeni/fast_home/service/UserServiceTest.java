package cm.domeni.fast_home.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import cm.domeni.fast_home.domain.user.*;
import cm.domeni.fast_home.dto.UserDTO;
import cm.domeni.fast_home.service.mapper.UserMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks UserService objectUnderTest;

  @Mock UserFactory userFactory;
  @Mock UserMapper userMapper;

  @Test
  void shouldMapToDataObjectAndUseTheFactoryWhenAskedForNewUserCreation() {
    // Given
    var userDTO = mock(UserDTO.class);
    var expected = UUID.randomUUID();

    var userData = mock(UserData.class);
    given(userMapper.map(userDTO)).willReturn(userData);

    var user = mock(User.class);
    given(user.getId()).willReturn(new UserId(expected));
    given(userFactory.create(userData)).willReturn(user);

    // When
    var id = objectUnderTest.createUser(userDTO);

    // Then
    assertThat(id).isNotNull().isEqualTo(expected);
  }
}
