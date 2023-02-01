package ee.valiit.back_bank_27.domain.location;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_bank_27.bank.Status.ACTIVE;


@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;

    public List<Location> findActiveLocations(Integer cityId) {
        List<Location> locations = locationRepository.findLocations(cityId, ACTIVE);
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }

    public List<Location> findActiveLocations() {
        List<Location> locations = locationRepository.findLocations(ACTIVE);
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }

// PIKALT LAHTI KIRJUTATUD LAHENDUS

//    public Location findLocation(Integer locationId) {
//        Optional<Location> optionalLocation = locationRepository.findById(locationId);
//        Location location = optionalLocation.get();
//        return location;

//    }  ALL ON SAMA ASJA ONE-LINER lahendus

    public Location findLocation(Integer locationId) {
        return locationRepository.findById(locationId).get();
    }

    public void saveAtmLocation(Location location) {
        locationRepository.save(location);
    }
}