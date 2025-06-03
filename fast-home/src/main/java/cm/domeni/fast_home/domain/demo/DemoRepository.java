package cm.domeni.fast_home.domain.demo;

import java.util.List;

public interface DemoRepository {

  Demo save(Demo value);

  List<Demo> findAll();
}
