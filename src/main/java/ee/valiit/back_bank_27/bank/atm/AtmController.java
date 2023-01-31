package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.LocationDto;
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
    @Operation(summary = "Finds all cities from database", description = "This information is used in frontend to greate cities dropdown")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = atmService.getAllCities();
        return cities;
    }

    @GetMapping("/atm/locations")
    @Operation(summary = "Finds all locations from database", description = "cityId = 0 returns all ATM locations")
    public List<LocationDto> getAtmLocations(@RequestParam Integer cityId) {

        List<LocationDto> locations = atmService.getAtmLocations(cityId);

        return locations;
    }


}
