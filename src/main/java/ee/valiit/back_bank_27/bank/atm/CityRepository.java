package ee.valiit.back_bank_27.bank.atm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor {


    List<City> findAll();

}