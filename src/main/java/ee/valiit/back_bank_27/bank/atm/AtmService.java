package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeDto;
import ee.valiit.back_bank_27.domain.location.Location;
import ee.valiit.back_bank_27.domain.location.LocationMapper;
import ee.valiit.back_bank_27.domain.location.LocationService;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import ee.valiit.back_bank_27.domain.location.transaction.LocationTransaction;
import ee.valiit.back_bank_27.domain.location.transaction.Transaction;
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
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private Transaction transaction;

    @Resource
    private LocationTransaction locationTransaction;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {

        List<Location> locations;

        if (cityId == 0) {
         locations = locationService.findActiveLocations();
    }
        else {
            locations = locationService.findLocations(cityId);
        }

        List<AtmLocationDto> locationDtos = locationMapper.toDtos(locations);

        // TODO: for-loopiga käia läbi  kõik locationDtos objektid
        //  igal tsüklil otsime andmebaasist locationId ja available abil, need read,
        //  mis kuuluvad antud locationi juurde. Tulemused mäpime TransactionTypeDto-deks.
        //  Seejärel lisame need AtmLocationDto välja transactionTypes külge.

        for (Location location : locations) {
            System.out.println(location.getCity());


        }
//        for (TransactionTypeDto transaction : locationDtos) {
//
//            }

        return locationDtos;
    }
}





















