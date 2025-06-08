package cm.domeni.fast_home.service.mapper;

import cm.domeni.fast_home.domain.user.User;
import cm.domeni.fast_home.domain.user.UserData;
import cm.domeni.fast_home.domain.user.UserId;
import cm.domeni.fast_home.dto.UserDTO;
import java.util.Optional;
import java.util.UUID;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    uses = {
      IdsMapper.class,
    },
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "phoneNumber", source = "phoneNumber")
  UserData map(UserDTO userDTO);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "phoneNumber", source = "phoneNumber")
  UserDTO map(User user);

  default UUID map(UserId value) {
    return Optional.ofNullable(value).map(UserId::getValue).map(UUID::fromString).orElse(null);
  }
}
