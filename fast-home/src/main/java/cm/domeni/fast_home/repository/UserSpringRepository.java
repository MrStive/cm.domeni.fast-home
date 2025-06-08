package cm.domeni.fast_home.repository;

import cm.domeni.fast_home.domain.user.User;
import cm.domeni.fast_home.domain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringRepository extends JpaRepository<User, UserId> {}
