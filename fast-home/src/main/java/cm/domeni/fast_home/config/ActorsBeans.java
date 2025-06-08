package cm.domeni.fast_home.config;

import cm.domeni.fast_home.domain.building.BuildingFactory;
import cm.domeni.fast_home.domain.building.BuildingRepository;
import cm.domeni.fast_home.domain.building.impl.BuildingFactoryImpl;
import cm.domeni.fast_home.domain.demo.DemoFactory;
import cm.domeni.fast_home.domain.demo.DemoFetcher;
import cm.domeni.fast_home.domain.demo.DemoRepository;
import cm.domeni.fast_home.domain.demo.impl.DemoFactoryImpl;
import cm.domeni.fast_home.domain.demo.impl.DemoFetcherImpl;
import cm.domeni.fast_home.domain.user.UserFactory;
import cm.domeni.fast_home.domain.user.UserRepository;
import cm.domeni.fast_home.domain.user.impl.UserFactoryImpl;
import cm.domeni.fast_home.repository.BuildingSpringRepository;
import cm.domeni.fast_home.repository.DemoSpringRepository;
import cm.domeni.fast_home.repository.UserSpringRepository;
import cm.domeni.fast_home.service.impl.BuildingRepositoryImpl;
import cm.domeni.fast_home.service.impl.DemoRepositoryImpl;
import cm.domeni.fast_home.service.impl.UserRepositoryImpl;
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

  @Bean
  public BuildingFactory buildingFactory(
      BuildingRepository buildingRepository, UserRepository userRepository) {
    return new BuildingFactoryImpl(buildingRepository, userRepository);
  }

  @Bean
  public BuildingRepository buildingRepository(BuildingSpringRepository buildingSpringRepository) {
    return new BuildingRepositoryImpl(buildingSpringRepository);
  }

  @Bean
  public UserFactory userFactory(UserRepository userRepository) {
    return new UserFactoryImpl(userRepository);
  }

  @Bean
  public UserRepository userRepository(UserSpringRepository userSpringRepository) {
    return new UserRepositoryImpl(userSpringRepository);
  }
}
