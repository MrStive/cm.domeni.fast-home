package cm.domeni.fast_home.domain.building;

import java.util.Set;
import lombok.Builder;

@Builder
public record BuildingData(
    String id,
    String name,
    String street,
    String city,
    String zipCode,
    Double latitude,
    Double longitude,
    Double totalArea,
    Integer floors,
    String ownerId,
    String reference,
    Set<BuildingAmenity> amenities) {}
