package cm.domeni.fast_home.repository;

import cm.domeni.fast_home.domain.building.Building;
import cm.domeni.fast_home.domain.building.BuildingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingSpringRepository extends JpaRepository<Building, BuildingId> {}
