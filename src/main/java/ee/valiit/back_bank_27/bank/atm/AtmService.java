package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.domain.location.Location;
import ee.valiit.back_bank_27.domain.location.LocationService;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmService {
    @Resource
    private CityService cityService;
    @Resource
    private CityMapper cityMapper;

    @Resource
    private LocationService locationService;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<Location> getAtmLocations(Integer cityId) {

        List<Location> locations;

        if (cityId == 0) {
            locations = locationService.findActiveLocations();
        } else {
            locations = locationService.findActiveLocations(cityId);
        }
        return locations;
    }
}
