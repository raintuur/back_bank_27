package ee.valiit.back_bank_27.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;

}
