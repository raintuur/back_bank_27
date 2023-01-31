package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeDto;
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
    @Operation(summary = "Finds all cities from system", description = "This information is used in frontend to create cities dropdown")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = atmService.getAllCities();
        return cities;
    }

    @GetMapping("atm/locations")
    @Operation(summary = "Finds ATM locations with transactions by cityId", description = "If cityId is '0' then all ATM locations are returned")
    public List<AtmLocationDto> getAtmLocations(@RequestParam Integer cityId) {
    return atmService.getAtmLocations(cityId);
    }

}
