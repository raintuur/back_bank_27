package ee.valiit.back_bank_27.domain.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService {
    @Resource
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }
}
