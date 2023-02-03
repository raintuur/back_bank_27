package ee.valiit.back_bank_27.bank;

import ee.valiit.back_bank_27.domain.city.CityMapper;
import ee.valiit.back_bank_27.domain.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private CityService cityService;


}
