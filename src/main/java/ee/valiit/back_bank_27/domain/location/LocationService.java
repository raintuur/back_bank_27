package ee.valiit.back_bank_27.domain.location;


import org.springframework.stereotype.Service;

import javax.xml.stream.Location;
import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findLocations(Integer cityId) {
        List<Location> locations = locationRepository.findLocations(cityId, "A");

return locations;
//        if (cityId == 0) {
//            List<AtmLocationDto> locations = locationRepository.findAll();
//            return locations;
//        } else {
//            List<AtmLocationDto> locations = locationRepository.findLocations(cityId, "A");
//            return locations;
//        }

    }

}
