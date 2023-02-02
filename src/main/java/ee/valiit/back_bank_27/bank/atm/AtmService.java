package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.*;
import ee.valiit.back_bank_27.domain.locationtransaction.location.Location;
import ee.valiit.back_bank_27.domain.locationtransaction.location.LocationMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.location.LocationService;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransaction;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransactionMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransactionService;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.Transaction;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.TransactionMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.TransactionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ee.valiit.back_bank_27.bank.Status.DEACTIVATED;

@Service
public class AtmService {

    @Resource
    private CityService cityService;
    @Resource
    private LocationService locationService;
    @Resource
    private LocationTransactionService locationTransactionService;
    @Resource
    private TransactionService transactionService;


    @Resource
    private CityMapper cityMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private LocationTransactionMapper locationTransactionMapper;
    @Resource
    private TransactionMapper transactionMapper;


    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {
        List<Location> locations = findLocations(cityId);
        List<AtmLocationDto> locationDtos = createLocationDtos(locations);

        return locationDtos;
    }

    public void deleteAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        location.setStatus(DEACTIVATED);
        String newName = location.getName() + " (Deactivated: " + LocalDateTime.now() + ")";
        location.setName(newName);

        locationService.saveAtmLocation(location);
    }

    public AtmLocationInfo getAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        AtmLocationInfo atmLocationInfo = locationMapper.toInfo(location);
        List<LocationTransaction> locationTransactions = locationTransactionService.findLocationTransactions(locationId);
        List<TransactionTypeInfo> transactionTypeInfos = locationTransactionMapper.toInfos(locationTransactions);
        atmLocationInfo.setTransactionTypes(transactionTypeInfos);
        return atmLocationInfo;
    }

    public List<TransactionTypeInfo> getAllTransactionTypes() {
        List<Transaction> transactions = transactionService.findAllTransactions();
        return transactionMapper.toInfos(transactions);
    }

    public void addAtmLocation(AtmLocationInfo atmLocationInfo) {
        Location location = createAndSaveLocation(atmLocationInfo);
        createAndSaveLocationTransactions(atmLocationInfo, location);
    }

    private List<Location> findLocations(Integer cityId) {
        List<Location> locations;

        if (cityId == 0) {
            locations = locationService.findLocations();
        } else {
            locations = locationService.findLocations(cityId);
        }
        return locations;
    }

    private List<AtmLocationDto> createLocationDtos(List<Location> locations) {
        List<AtmLocationDto> locationDtos = locationMapper.toDtos(locations);
        for (AtmLocationDto locationDto : locationDtos) {
            List<LocationTransaction> locationTransactions =
                    locationTransactionService.findLocationTransactions(locationDto.getLocationId(), true);
            List<TransactionTypeDto> transactionTypeDtos = locationTransactionMapper.toDtos(locationTransactions);
            locationDto.setTransactionTypes(transactionTypeDtos);
        }
        return locationDtos;
    }

    private Location createAndSaveLocation(AtmLocationInfo atmLocationInfo) {
        Location location = createLocation(atmLocationInfo);
        locationService.saveAtmLocation(location);
        return location;
    }

    private Location createLocation(AtmLocationInfo atmLocationInfo) {
        Location location = locationMapper.toEntity(atmLocationInfo);
        City city = cityService.findCity(atmLocationInfo.getCityId());
        location.setCity(city);
        return location;
    }

    private void createAndSaveLocationTransactions(AtmLocationInfo atmLocationInfo, Location location) {
        List<TransactionTypeInfo> transactionTypes = atmLocationInfo.getTransactionTypes();
        List<LocationTransaction> locationTransactions = new ArrayList<>();
        for (TransactionTypeInfo transactionType : transactionTypes) {
            LocationTransaction locationTransaction = createLocationTransaction(location, transactionType);
            locationTransactions.add(locationTransaction);
        }
        locationTransactionService.saveLocationTransactions(locationTransactions);
    }

    private LocationTransaction createLocationTransaction(Location location, TransactionTypeInfo transactionType) {
        LocationTransaction locationTransaction = new LocationTransaction();
        locationTransaction.setLocation(location);
        Transaction transaction = transactionService.findTransaction(transactionType.getTypeId());
        locationTransaction.setTransaction(transaction);
        locationTransaction.setAvailable(transactionType.getIsSelected());
        return locationTransaction;
    }
}
