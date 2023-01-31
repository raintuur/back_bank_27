package ee.valiit.back_bank_27.bank.atm;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmService {

    @Resource
    private CityService cityService;

    @Resource
    private CityMapper cityMapper;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }
}

    public List<Cities> getAllCities() {

        List<Cities> cities = findAllCities();

        return

    }
}
