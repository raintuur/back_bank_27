package ee.valiit.back_bank_27.domain.location;

import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;

    public List<Location> findActiveLocations(Integer cityId) {
        List<Location> locations = locationRepository.findLocations(cityId, "A");
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }



    public List<Location> findActiveLocations() {
        List<Location> locations = locationRepository.findLocations("A");
        Validator.validateAtmLocationsAvailable(locations);
        return locations;
    }
}
