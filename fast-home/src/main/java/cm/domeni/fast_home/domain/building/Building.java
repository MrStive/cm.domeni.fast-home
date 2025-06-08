package cm.domeni.fast_home.domain.building;

import cm.domeni.fast_home.domain.FastHomeEntity;
import cm.domeni.fast_home.domain.user.User;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
@Table(name = "t_building")
public class Building implements FastHomeEntity<BuildingId> {

  @Builder.Default
  @EmbeddedId
  @AttributeOverride(name = "value", column = @Column(name = "c_id"))
  private BuildingId id = new BuildingId();

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "c_name"))
  private BuildingName name;

  @Embedded
  @AttributeOverride(name = "street", column = @Column(name = "c_street"))
  @AttributeOverride(name = "city", column = @Column(name = "c_city"))
  @AttributeOverride(name = "zipCode", column = @Column(name = "c_zip_code"))
  private BuildingAddress address;

  @Embedded
  @AttributeOverride(name = "latitude", column = @Column(name = "c_latitude"))
  @AttributeOverride(name = "longitude", column = @Column(name = "c_longitude"))
  private BuildingLocation location;

  @Column(name = "c_total_area")
  private Double totalArea;

  @Column(name = "c_floors")
  private Integer floors;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "c_owner_id")
  private User owner;

  @Column(name = "c_reference")
  private String reference;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "t_building_amenity", joinColumns = @JoinColumn(name = "c_building_id"))
  @Column(name = "c_amenity")
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private Set<BuildingAmenity> amenities = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Building building)) {
      return false;
    }
    return Objects.equals(id, building.id);
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
