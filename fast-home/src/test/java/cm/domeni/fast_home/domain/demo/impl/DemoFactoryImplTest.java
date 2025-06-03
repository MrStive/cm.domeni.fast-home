package cm.domeni.fast_home.domain.demo.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import cm.domeni.fast_home.domain.demo.*;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoFactoryImplTest {
  @InjectMocks DemoFactoryImpl objectUnderTest;
  @Mock DemoRepository demoRepository;

  @Test
  void createTest() {
      //Given
    String id = UUID.randomUUID().toString();
    String name = "name";
    DemoData demoData = DemoData.builder().id(id).name(name).build();
      Demo expected = mock(Demo.class);
      given(demoRepository.save(any())).willReturn(expected);

    //When
    Demo result = objectUnderTest.create(demoData);

    //Then
    verify(demoRepository)
        .save(
            assertArg(
                demo ->
                    assertThat(demo)
                        .usingRecursiveComparison()
                            .ignoringFieldsOfTypes()
                            .ignoringFieldsOfTypes(DemoId.class)
                        .isEqualTo(
                            Demo.builder()
                                .name(DemoName.builder().value(name).build())
                                .build())));
    assertThat(result).isNotNull().isEqualTo(expected);
  }
}
