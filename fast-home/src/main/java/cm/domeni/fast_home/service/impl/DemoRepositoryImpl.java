package cm.domeni.fast_home.service.impl;

import cm.domeni.fast_home.domain.demo.Demo;
import cm.domeni.fast_home.domain.demo.DemoRepository;
import cm.domeni.fast_home.repository.DemoSpringRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DemoRepositoryImpl implements DemoRepository {
  private final DemoSpringRepository demoSpringRepository;

  @Override
  public Demo save(Demo value) {
    return demoSpringRepository.save(value);
  }

  @Override
  public List<Demo> findAll() {
    return new ArrayList<>(demoSpringRepository.findAll());
  }
}
