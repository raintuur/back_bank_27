package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
import ee.valiit.back_bank_27.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtmController {
    @Resource
    private AtmService atmService;


    @GetMapping("/atm/locations")
    @Operation(summary = "Finds ATM locations with transaction data by cityId.", description = "If cityId is '0' then all ATM locations are returned.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Could not find any ATM locations", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<AtmLocationDto> getAtmLocations(@RequestParam Integer cityId) {
        List<AtmLocationDto> atmLocations = atmService.getAtmLocations(cityId);
        return atmLocations;
    }


    @GetMapping("/atm/cities")
    @Operation(summary = "Finds all cities from system/database.", description = "This information is used in frontend to create cities dropdown.")
    public List<CityDto> getAllCities() {
        List<CityDto> cities = atmService.getAllCities();
        return cities;
    }
}