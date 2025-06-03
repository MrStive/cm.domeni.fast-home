package cm.domeni.fast_home.service.mapper;

import cm.domeni.fast_home.domain.demo.Demo;
import cm.domeni.fast_home.domain.demo.DemoData;
import cm.domeni.fast_home.domain.demo.DemoName;
import cm.domeni.fast_home.dto.DemoDTO;
import java.util.Optional;
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
public interface DemoMapper {

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "name")
  @Mapping(target = "id")
  DemoData map(DemoDTO demoDTO);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id")
  @Mapping(target = "name")
  DemoDTO map(Demo demo);

  default String map(DemoName value) {
    return Optional.ofNullable(value).map(DemoName::getValue).orElse(null);
  }
}
