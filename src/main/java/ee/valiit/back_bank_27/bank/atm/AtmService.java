package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationInfo;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeDto;
import ee.valiit.back_bank_27.domain.location.Location;
import ee.valiit.back_bank_27.domain.location.LocationMapper;
import ee.valiit.back_bank_27.domain.location.LocationService;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import ee.valiit.back_bank_27.domain.location.transaction.LocationTransaction;
import ee.valiit.back_bank_27.domain.location.transaction.LocationTransactionMapper;
import ee.valiit.back_bank_27.domain.location.transaction.LocationTransactionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtmService {

    @Resource
    private CityService cityService;

    @Resource
    private LocationService locationService;

    @Resource
    private LocationTransactionService locationTransactionService;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private LocationTransactionMapper locationTransactionMapper;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {

        List<Location> locations;

        if (cityId == 0) {
            locations = locationService.findActiveLocations();
        } else {
            locations = locationService.findActiveLocations(cityId);
        }

        List<AtmLocationDto> locationDtos = locationMapper.toDtos(locations);

        // TODO: for loopiga kaia labi koik locationDtos
        // TODO: objektid igal tsuklil otsime andmebaasist locationId ja available abil need read, mis kuuluvad
        // TODO: antud locationi juurde. Tulemused mapimeTransactionTypeDto-deks. Seejarel lisame need AtmLocationDto
        //  valja transactionTypes kylge.

        for (AtmLocationDto locationDto : locationDtos) {
            List<LocationTransaction> locationTransactions = locationTransactionService.findLocationTransactions(locationDto.getLocationId(), true);
            List<TransactionTypeDto> transactionTypeDtos = locationTransactionMapper.toDtos(locationTransactions);
            locationDto.setTransactionTypes(transactionTypeDtos);

        }
        return locationDtos;
    }

    public void deleteAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        String currentName = location.getName();
        String newName = currentName + " (deactivated: " + LocalDateTime.now() + ")";
        location.setName(newName);
        location.setStatus(Status.DEACTIVATED);
        locationService.saveAtmLocation(location);

    }

    public AtmLocationInfo getAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        locationMapper.toInfo(location);

        return null;
    }
}





















