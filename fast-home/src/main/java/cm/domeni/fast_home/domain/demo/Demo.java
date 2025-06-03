package cm.domeni.fast_home.domain.demo;

import cm.domeni.fast_home.domain.FastHomeEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

@FieldNameConstants
@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "t_demo")
public class Demo implements FastHomeEntity<DemoId> {

  @Builder.Default
  @EmbeddedId
  @AttributeOverride(name = "value", column = @Column(name = "c_id"))
  private DemoId id = new DemoId();

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "c_name"))
  private DemoName name;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Demo demo)) {
      return false;
    }
    return Objects.equals(id, demo.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public boolean isDeleted() {
    return false;
  }

  @Override
  public void markAsDeleted() {}

  @Override
  public void markAsNotDeleted() {}
}
