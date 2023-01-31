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
    @Operation(summary = "finds all cities in database", description = "Front end uses this information to create cities dropdown")
    public List<CityDto> getAllCities(){

        return atmService.getAllCities();
    }

    @GetMapping("/atm/location")
    @Operation(summary = "finds a list of atm locations with transaction data, by cityId", description = "if cityId = 0 returns all ATM locations")
    public List<AtmLocationDto> getAtmLocations(@RequestParam Integer cityId){

        return atmService.getAtmLocations(cityId);
    }


}
