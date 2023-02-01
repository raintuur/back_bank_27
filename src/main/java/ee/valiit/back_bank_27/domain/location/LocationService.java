package ee.valiit.back_bank_27.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.valiit.back_bank_27.validation.Validator.validateAtmLocationsAvailable;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;

    public List<Location> findActiveLocations(Integer cityId) {
        List<Location> locations = locationRepository.findLocations(cityId, "A");
        validateAtmLocationsAvailable(locations);
        return locations;
    }



    public List<Location> findActiveLocations() {
        List<Location> locations = locationRepository.findLocations("A");
        return locations;
    }
}