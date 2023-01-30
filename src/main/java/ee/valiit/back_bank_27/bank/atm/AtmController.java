package ee.valiit.back_bank_27.bank.atm;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmController {

    @Resource
    private AtmService atmService;

    @GetMapping("atm/cities")
    public List<CityDto> getAllCities() {
       return atmService.getAllCities();

    }

}
