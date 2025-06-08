package cm.domeni.fast_home.domain.building;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

@Getter
@Embeddable
public class BuildingId implements Serializable {
  private String value;

  public BuildingId() {
    this.value = UUID.randomUUID().toString();
  }

  public BuildingId(String value) {
    this.value = value;
  }

  public BuildingId(UUID value) {
    this.value = value.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BuildingId that)) {
      return false;
    }
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
