package ee.valiit.back_bank_27.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<AtmLocationDto, Integer> {
    @Query("select a from AtmLocationDto a where a.city.id = ?1 and a.status = ?2 order by a.city.name, a.name")
    List<AtmLocationDto> findLocations(Integer id, String status);
}