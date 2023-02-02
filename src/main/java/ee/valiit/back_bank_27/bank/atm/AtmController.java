package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationInfo;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Resource
    private AtmService atmService;



    @GetMapping("/cities")
    @Operation(summary = "finds all cities in database", description = "Front end uses this information to create cities dropdown")
    public List<CityDto> getAllCities() {
        return atmService.getAllCities();
    }

    @GetMapping("/locations")
    @Operation(summary = "finds a list of atm locations with transaction data, by cityId", description = "if cityId = 0 returns all ATM locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Could not find any ATM locations")})
    public List<AtmLocationDto> getAtmLocations(@RequestParam Integer cityId) {
        return atmService.getAtmLocations(cityId);
    }

    @PostMapping("/location")
    @Operation(summary = "Add ATM location", description = "adds ATM location to db tables (location & location_transaction")
    public void addAtmLocation(@RequestBody AtmLocationInfo atmLocationInfo){
        atmService.addAtmLocation(atmLocationInfo);
    }

    @GetMapping("/transaction-types")
    @Operation(summary = "Find all transaction types", description = "returns all possible transaction types that could be added to any location")
    public List<TransactionTypeInfo> getAllTransactionTypes(){
        return atmService.getAllTransactionTypes();
    }

    @GetMapping("/location")
    @Operation(summary = "find atm location by locationId", description = "??")
    public AtmLocationInfo getAtmLocation(@RequestParam Integer locationId) {
        return atmService.getAtmLocation(locationId);
    }


    @DeleteMapping("/location")
    @Operation(summary = "deletes an atm location by location ID", description = "back-end changes the status of the atm location to inactive")
    public void deleteAtmLocation(@RequestParam Integer locationId) {
        atmService.deleteAtmLocation(locationId);
    }


}
