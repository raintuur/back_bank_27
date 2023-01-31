package ee.valiit.back_bank_27.bank.atm;

`package ee.valiit.back_bank_27.domain;

import jakarta.annotation.Resource;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public List<City> findAllCities() {
        List<City> city = cityRepository.findAll();

        return city;
    }


}