package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationResponse;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import ee.valiit.back_bank_27.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Operation(summary = "Finds all cities from system/database", description = "This information is used in frontend to create cities dropdown")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = atmService.getAllCities();
        return cities;
    }

    @PostMapping("/location")
    @Operation(summary = "Add ATM location", description = "Adds ATM location to db tables 'location' and 'location_transaction'")
    public void addAtmLocation(@RequestBody AtmLocationDto atmLocationDto) {
        atmService.addAtmLocation(atmLocationDto);
    }

    @GetMapping("/location")
    @Operation(summary = "Finds ATM location by locationId", description = "Finds all ATM locations from db table 'location_transaction'")
    public AtmLocationDto getAtmLocation(@RequestParam Integer locationId) {
        return atmService.getAtmLocation(locationId);
    }

    @DeleteMapping("/location")
    @Operation(summary = "Deletes ATM location", description = "ATM location status is changed in database")
    public void deleteAtmLocation(@RequestParam Integer locationId) {
        atmService.deleteAtmLocation(locationId);
    }

    @GetMapping("/locations")
    @Operation(summary = "Finds ATM locations with transactions info by cityId", description = "If cityId is '0' then all ATM locations are returned")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Could not find any ATM locations", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<AtmLocationResponse> getAtmLocations(@RequestParam Integer cityId) {
        List<AtmLocationResponse> atmLocations = atmService.getAtmLocations(cityId);
        return atmLocations;
    }


    @GetMapping("/transaction-types")
    @Operation(summary = "Finds all transation types", description = "Finds all transaction types from db table 'transaction'")
    public List<TransactionTypeInfo> getAllTransactionTypes() {
        List<TransactionTypeInfo> transactions = atmService.getAllTransactionTypes();
        return transactions;
    }
}
