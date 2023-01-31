package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.domain.location.Location;
import ee.valiit.back_bank_27.domain.location.LocationMapper;
import ee.valiit.back_bank_27.domain.location.LocationMapperImpl;
import ee.valiit.back_bank_27.domain.location.LocationService;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmService {

    @Resource
    private CityService cityService;

    @Resource
    private LocationService locationService;

    @Resource
    private CityMapper cityMapper;


    @Resource
    private LocationMapper locationMapper;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {
        List<Location> locations;
        if (cityId == 0) {
           // TOdo siis leia kõik locationid
          locations =  locationService.findActiveLocations();
        } else {
            //TODO: leia vastava cityId locationid
             locations = locationService.findLocations(cityId);
        }
   locationMapper.toDtos(locations);

    return null;
    }
}





















