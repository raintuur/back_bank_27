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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ee.valiit.back_bank_27.bank.Status.DEACTIVATED;

@Service
public class AtmService {

    @Resource
    private CityService cityService;

    @Resource
    private TransactionService transactionService;

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
    @Resource
    private TransactionMapper transactionMapper;

    public List<CityDto> getAllCities() {
        List<City> cities = cityService.getAllCities();
        List<CityDto> cityDtos = cityMapper.toDtos(cities);
        return cityDtos;
    }

    public List<AtmLocationDto> getAtmLocations(Integer cityId) {

        List<Location> locations;

        if (cityId == 0) {
            locations =  locationService.findActiveLocations();
        } else {
            locations = locationService.findActiveLocations(cityId);
        }

        List<AtmLocationDto> locationDtos = locationMapper.toDtos(locations);

        // TODO: for-loopiga käia läbi  kõik locationDtos objektid
        //  igal tsüklil otsime andmebaasist locationId ja isAvailable abil, need read,
        //  mis kuuluvad antud locationi juurde. Tulemused mäpime TransactionTypeDto-deks.
        //  Seejärel lisame need AtmLocationDto välja transactionTypes külge.
        //
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
        String newName = currentName + " (deactivated: "  + LocalDateTime.now() + ")";
        location.setName(newName);
        location.setStatus(DEACTIVATED);
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
        List<TransactionTypeInfo> transactionTypeInfos = transactionMapper.toInfos(transactions);

        return transactionTypeInfos;
    }

    public void addAtmLocation(AtmLocationInfo atmLocationInfo) {
        Location location = locationMapper.toEntity(atmLocationInfo);
        City city = cityService.findCity(atmLocationInfo.getCityId());
        location.setCity(city);
        locationService.saveAtmLocation(location);

        List<TransactionTypeInfo> transactionTypes = atmLocationInfo.getTransactionTypes();

        List<LocationTransaction> locationTransactions = new ArrayList<>();

        for (TransactionTypeInfo transactionType : transactionTypes) {
            LocationTransaction locationTransaction = new LocationTransaction();
            locationTransaction.setLocation(location);
            Transaction transaction = transactionService.findTransaction(transactionType.getTypeId());
            locationTransaction.setTransaction(transaction);
            locationTransaction.setAvailable(transactionType.getIsSelected());
            locationTransactions.add(locationTransaction);
        }

        locationTransactionService.saveLocationTransactions(locationTransactions);

    }
}





















