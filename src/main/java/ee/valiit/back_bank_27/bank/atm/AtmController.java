package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.domain.location.Location;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmController {
    @Resource
    private AtmService atmService;

    @GetMapping("/atm/cities")
    @Operation (summary = "Finds all cities from system/database.", description = "This information is used in frontend to create cities dropdown.")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = atmService.getAllCities();
        return cities;
    }
    @GetMapping("/atm/locations")
    @Operation (summary = "Finds ATM locations with transaction data by cityId.", description = "If cityId is '0', then all ATM locations are returned.")
    public List<Location> getAtmLocations(@RequestParam Integer cityId){
        return atmService.getAtmLocations(cityId);
    }
}