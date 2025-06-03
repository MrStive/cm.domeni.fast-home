package cm.domeni.fast_home.service.mapper;

import cm.domeni.fast_home.domain.demo.DemoId;
import java.util.Optional;
import java.util.UUID;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IdsMapper {

  default DemoId mapDemoId(UUID id) {
    return Optional.ofNullable(id).map(DemoId::new).orElse(null);
  }

  default UUID mapDemoId(DemoId id) {
    return Optional.ofNullable(id).map(DemoId::getValue).map(UUID::fromString).orElse(null);
  }
}
