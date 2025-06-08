package cm.domeni.fast_home.domain.building;

import java.util.List;

public interface BuildingRepository {

  Building save(Building value);

  List<Building> findAll();
}
