package cm.domeni.fast_home.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import cm.domeni.fast_home.domain.demo.DemoId;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdsMapperTest {

  IdsMapper objectUnderTest;

  @BeforeEach
  void setUp() {
    objectUnderTest = new IdsMapperImpl();
  }

  @Test
  void mapDemoIdToUUIDTest() {
    // Given
    var uuid = UUID.randomUUID();
    var demoId = new DemoId(uuid);

    // When
    var result = objectUnderTest.mapDemoId(demoId);

    // Then
    assertThat(result).isEqualTo(uuid);
  }

  @Test
  void mapDemoIdToUUIDNullTest() {
    // When
    var result = objectUnderTest.mapDemoId((DemoId) null);

    // Then
    assertThat(result).isNull();
  }

  @Test
  void mapUUIDToDemoIdTest() {
    // Given
    var uuid = UUID.randomUUID();

    // When
    var result = objectUnderTest.mapDemoId(uuid);

    // Then
    assertThat(result).isNotNull();
    assertThat(result.getValue()).isEqualTo(uuid.toString());
  }

  @Test
  void mapUUIDToDemoIdNullTest() {
    // When
    var result = objectUnderTest.mapDemoId((UUID) null);

    // Then
    assertThat(result).isNull();
  }
}
