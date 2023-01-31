package ee.valiit.back_bank_27.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.city.id = ?1 and l.status = ?2 order by l.city.name, l.name")
    List<Location> findLocations(@Nullable Integer cityId, String status);


}