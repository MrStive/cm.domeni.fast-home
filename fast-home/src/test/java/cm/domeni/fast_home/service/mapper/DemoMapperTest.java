package cm.domeni.fast_home.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import cm.domeni.fast_home.domain.demo.Demo;
import cm.domeni.fast_home.domain.demo.DemoData;
import cm.domeni.fast_home.domain.demo.DemoId;
import cm.domeni.fast_home.domain.demo.DemoName;
import cm.domeni.fast_home.dto.DemoDTO;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemoMapperTest {

  DemoMapper objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new DemoMapperImpl(new IdsMapperImpl());
  }

  @Test
  void mapFromDTOToDataTest() {
    var id = UUID.randomUUID();
    var name = "name";
    var data = objectUnderTest.map(new DemoDTO().id(id).name(name));

    assertThat(data).isNotNull().returns(id.toString(), DemoData::id).returns(name, DemoData::name);
  }

  @Test
  void mapDemoToDTOTest() {
    var id = new DemoId(UUID.randomUUID());
    var name = "name";
    var dto = objectUnderTest.map(Demo.builder().id(id).name(new DemoName(name)).build());

    assertThat(dto)
        .isNotNull()
        .usingRecursiveComparison()
        .isEqualTo(new DemoDTO().id(UUID.fromString(id.getValue())).name(name));
  }
}
