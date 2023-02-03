package ee.valiit.back_bank_27.bank;

import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @GetMapping("/cities")
    @Operation(summary = "Finds all cities from system/database", description = "This information is used in frontend to create cities dropdown")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = citiesService.getAllCities();
        return cities;
    }
}
