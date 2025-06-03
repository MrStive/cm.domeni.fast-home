package cm.domeni.fast_home.config;

import cm.domeni.fast_home.domain.demo.DemoFactory;
import cm.domeni.fast_home.domain.demo.DemoFetcher;
import cm.domeni.fast_home.domain.demo.DemoRepository;
import cm.domeni.fast_home.domain.demo.impl.DemoFactoryImpl;
import cm.domeni.fast_home.domain.demo.impl.DemoFetcherImpl;
import cm.domeni.fast_home.repository.DemoSpringRepository;
import cm.domeni.fast_home.service.impl.DemoRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ActorsBeans {

  @Bean
  public DemoFactory demoFactory(DemoRepository demoRepository) {
    return new DemoFactoryImpl(demoRepository);
  }

  @Bean
  public DemoRepository demoRepository(DemoSpringRepository demoSpringRepository) {
    return new DemoRepositoryImpl(demoSpringRepository);
  }

  @Bean
  public DemoFetcher demoFetcher(DemoRepository demoRepository) {
    return new DemoFetcherImpl(demoRepository);
  }
}
