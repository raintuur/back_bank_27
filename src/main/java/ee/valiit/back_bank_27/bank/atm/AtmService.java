package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.*;
import ee.valiit.back_bank_27.domain.city.City;
import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import ee.valiit.back_bank_27.domain.locationtransaction.location.Location;
import ee.valiit.back_bank_27.domain.locationtransaction.location.LocationMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.location.LocationService;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransaction;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransactionMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.LocationTransactionService;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.Transaction;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.TransactionMapper;
import ee.valiit.back_bank_27.domain.locationtransaction.transaction.TransactionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private LocationMapper locationMapper;

    @Resource
    private LocationTransactionMapper locationTransactionMapper;

    @Resource
    private TransactionMapper transactionMapper;

    public List<AtmLocationResponse> getAtmLocations(Integer cityId) {
        List<Location> locations = findLocations(cityId);

        List<AtmLocationResponse> atmLocations = createAtmLocations(locations);
        return atmLocations;
    }

    public void deleteAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        String currentName = location.getName();
        String newName = currentName + " (deactivated: " + LocalDateTime.now() + ")";
        location.setName(newName);
        location.setStatus(DEACTIVATED);
        locationService.saveAtmLocation(location);
    }

    public AtmLocationDto getAtmLocation(Integer locationId) {
        Location location = locationService.findLocation(locationId);
        AtmLocationDto atmLocationDto = locationMapper.toInfo(location);

        List<LocationTransaction> locationTransactions = locationTransactionService.findLocationTransactions(locationId);

        List<TransactionTypeInfo> transactionTypeInfos = locationTransactionMapper.toInfos(locationTransactions);
        atmLocationDto.setTransactionTypes(transactionTypeInfos);
        return atmLocationDto;
    }

    public List<TransactionTypeInfo> getAllTransactionTypes() {
        List<Transaction> transactions = transactionService.findAllTransactions();
        List<TransactionTypeInfo> transactionTypeInfos = transactionMapper.toInfos(transactions);
        return transactionTypeInfos;
    }
    @Transactional
    public void addAtmLocation(AtmLocationDto atmLocationDto) {
        Location location = createAndSaveLocation(atmLocationDto);
        createAndSaveLocationTransactions(atmLocationDto, location);
    }

    @Transactional
    public void editAtmLocation(Integer locationId, AtmLocationDto atmLocationDto) {
        updateAndSaveLocation(locationId, atmLocationDto);
        updateAndSaveLocationTransaction(locationId, atmLocationDto);
    }

    private void updateAndSaveLocationTransaction(Integer locationId, AtmLocationDto atmLocationDto) {
        List<LocationTransaction> locationTransactions = getUpdatedLocationTransactions(locationId, atmLocationDto);
        locationTransactionService.saveLocationTransactions(locationTransactions);
    }

    private void updateAndSaveLocation(Integer locationId, AtmLocationDto atmLocationDto) {
        Location location = getUpdatedLocation(locationId, atmLocationDto);
        locationService.saveAtmLocation(location);
    }

    private List<Location> findLocations(Integer cityId) {
        List<Location> locations;
        if (cityId == 0) {
            locations = locationService.findActiveLocations();
        } else {
            locations = locationService.findActiveLocations(cityId);
        }
        return locations;
    }

    private List<AtmLocationResponse> createAtmLocations(List<Location> locations) {
        List<AtmLocationResponse> locationDtos = locationMapper.toDtos(locations);
        for (AtmLocationResponse locationDto : locationDtos) {
            List<LocationTransaction> locationTransactions = locationTransactionService.findLocationTransactions(locationDto.getLocationId(), true);
            List<TransactionTypeDto> transactionTypeDtos = locationTransactionMapper.toDtos(locationTransactions);
            locationDto.setTransactionTypes(transactionTypeDtos);
        }
        return locationDtos;
    }

    private Location createAndSaveLocation(AtmLocationDto atmLocationDto) {
        Location location = createLocation(atmLocationDto);
        locationService.saveAtmLocation(location);
        return location;
    }

    private Location createLocation(AtmLocationDto atmLocationDto) {
        Location location = locationMapper.toEntity(atmLocationDto);
        City city = cityService.findCity(atmLocationDto.getCityId());
        location.setCity(city);
        return location;
    }

    private void createAndSaveLocationTransactions(AtmLocationDto atmLocationDto, Location location) {
        List<TransactionTypeInfo> transactionTypes = atmLocationDto.getTransactionTypes();
        List<LocationTransaction> locationTransactions = createLocationTransactions(location, transactionTypes);
        locationTransactionService.saveLocationTransactions(locationTransactions);
    }

    private List<LocationTransaction> createLocationTransactions(Location location, List<TransactionTypeInfo> transactionTypes) {
        List<LocationTransaction> locationTransactions = new ArrayList<>();
        for (TransactionTypeInfo transactionType : transactionTypes) {
            LocationTransaction locationTransaction = createLocationTransaction(location, transactionType);
            locationTransactions.add(locationTransaction);
        }
        return locationTransactions;
    }

    private LocationTransaction createLocationTransaction(Location location, TransactionTypeInfo transactionType) {
        LocationTransaction locationTransaction = new LocationTransaction();
        locationTransaction.setLocation(location);
        Transaction transaction = transactionService.findTransaction(transactionType.getTypeId());
        locationTransaction.setTransaction(transaction);
        locationTransaction.setAvailable(transactionType.getIsSelected());
        return locationTransaction;
    }

    private Location getUpdatedLocation(Integer locationId, AtmLocationDto atmLocationDto) {
        Location location = locationService.findLocation(locationId);
        locationMapper.updateLocation(atmLocationDto, location);
        updateCityIfChanged(atmLocationDto.getCityId(), location);
        return location;
    }

    private void updateCityIfChanged(Integer dtoCityId, Location location) {
        if (!dtoCityId.equals(location.getCity().getId())) {
            City city = cityService.findCity(dtoCityId);
            location.setCity(city);
        }
    }

    private List<LocationTransaction> getUpdatedLocationTransactions(Integer locationId, AtmLocationDto atmLocationDto) {
        List<LocationTransaction> locationTransactions = new ArrayList<>();
        List<TransactionTypeInfo> transactionTypes = atmLocationDto.getTransactionTypes();
        for (TransactionTypeInfo transactionType : transactionTypes) {
            LocationTransaction locationTransaction = locationTransactionService.findLocation(locationId, transactionType.getTypeId());
            locationTransaction.setAvailable(transactionType.getIsSelected());
            locationTransactions.add(locationTransaction);
        }
        return locationTransactions;
    }
}