package ee.valiit.back_bank_27.domain.location;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.domain.location.transaction.LocationTransactionRepository;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;
    private final LocationTransactionRepository locationTransactionRepository;

    public LocationService(LocationTransactionRepository locationTransactionRepository) {
        this.locationTransactionRepository = locationTransactionRepository;
    }

    public List<Location> findActiveLocations(Integer cityId) {
        List<Location> locations = locationRepository.findLocations(cityId, Status.ACTIVE);
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }



    public List<Location> findActiveLocations() {
        List<Location> locations = locationRepository.findLocations(Status.ACTIVE);
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }

    public Location findLocation(Integer locationId) {
       return locationRepository.findById(locationId).get();
    }

    public void saveAtmLocation(Location location) {
        locationRepository.save(location);
    }
}
