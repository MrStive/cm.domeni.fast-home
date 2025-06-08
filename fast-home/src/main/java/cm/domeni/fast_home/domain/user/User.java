package cm.domeni.fast_home.domain.user;

import cm.domeni.fast_home.domain.FastHomeEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
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
@Table(name = "t_user")
public class User implements FastHomeEntity<UserId> {

  @Builder.Default
  @EmbeddedId
  @AttributeOverride(name = "value", column = @Column(name = "c_id"))
  private UserId id = new UserId();

  @Column(name = "c_first_name")
  private String firstName;

  @Column(name = "c_last_name")
  private String lastName;

  @Column(name = "c_email", unique = true)
  private String email;

  @Column(name = "c_phone_number")
  private String phoneNumber;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User user)) {
      return false;
    }
    return Objects.equals(id, user.id);
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
