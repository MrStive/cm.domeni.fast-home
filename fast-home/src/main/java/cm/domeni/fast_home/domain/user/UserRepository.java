package cm.domeni.fast_home.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  User save(User value);

  List<User> findAll();

  Optional<User> findById(UserId id);
}
