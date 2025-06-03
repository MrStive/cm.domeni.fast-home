package cm.domeni.fast_home.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import cm.domeni.fast_home.domain.demo.*;
import cm.domeni.fast_home.dto.DemoDTO;
import cm.domeni.fast_home.service.mapper.DemoMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoServiceTest {

  @InjectMocks DemoService objectUnderTest;

  @Mock DemoFactory demoFactory;
  @Mock DemoMapper demoMapper;
  @Mock DemoFetcher demoFetcher;

  @Test
  void shouldMapToDataObjectAndUseTheFactoryWhenAskedForNewDemoCreation() {
    var demoDTO = mock(DemoDTO.class);
    var expected = UUID.randomUUID();

    var demoData = mock(DemoData.class);
    given(demoMapper.map(demoDTO)).willReturn(demoData);

    var demo = mock(Demo.class);
    given(demo.getId()).willReturn(new DemoId(expected));
    given(demoFactory.create(demoData)).willReturn(demo);

    var id = objectUnderTest.createDemo(demoDTO);

    assertThat(id).isNotNull().isEqualTo(expected);
  }

  @Test
  void shouldDelegateToSpringRepositoryWhenAskedForAllDemos() {
    var demoDto1 = mock(DemoDTO.class);
    var demoDto2 = mock(DemoDTO.class);

    var demo1 = mock(Demo.class);
    var demo2 = mock(Demo.class);
    given(demoMapper.map(demo1)).willReturn(demoDto1);
    given(demoMapper.map(demo2)).willReturn(demoDto2);

    given(demoFetcher.loadAllDemos()).willReturn(List.of(demo1, demo2));

    var result = objectUnderTest.fetchAllDemos();
    assertThat(result).isNotNull().hasSize(2).contains(demoDto1).contains(demoDto2);
  }
}
