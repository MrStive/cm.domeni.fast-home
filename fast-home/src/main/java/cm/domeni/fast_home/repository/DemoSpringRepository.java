package cm.domeni.fast_home.repository;

import cm.domeni.fast_home.domain.demo.Demo;
import cm.domeni.fast_home.domain.demo.DemoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoSpringRepository extends JpaRepository<Demo, DemoId> {}
