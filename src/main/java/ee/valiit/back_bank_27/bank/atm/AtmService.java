package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
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
    private LocationService locationService;

    @Resource
    private CityMapper cityMapper;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {

        if(cityId == 0) {
            //  todo: siis leia koik locationid
        } else {
            // todo: leia vastava cityId locationid
        }


        return null;
    }
}





















