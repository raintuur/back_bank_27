package ee.valiit.back_bank_27.bank.atm;

import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationDto;
import ee.valiit.back_bank_27.bank.atm.dto.AtmLocationInfo;
import ee.valiit.back_bank_27.bank.atm.dto.CityDto;
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

    @GetMapping("/location")
    @Operation(summary = "Finds ATM location by Id", description = "?")
    public AtmLocationInfo getAtmLocation(@RequestParam Integer locationId) {
        return atmService.getAtmLocation(locationId);
    }

    @GetMapping("/cities")
    @Operation(summary = "Finds all cities from the system", description = "This information is used on frontend to create dropdown of cities")
    public List<CityDto> getAllCities() {
        return atmService.getAllCities();
    }

    @GetMapping("/locations")
    @Operation(summary = "Finds ATM locations with transactions by cityId", description = "If cityId is 0 then returns all ATM locations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "No ATM Locations found", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<AtmLocationDto> getAtmLocations(@RequestParam Integer cityId) {
        return atmService.getAtmLocations(cityId);
    }

    @DeleteMapping("/location")
    @Operation(summary = "Deletes ATM location", description = "Actually we just change the ATM location status in DB")
    public void deleteAtmLocation(@RequestParam Integer locationId) {
        atmService.deleteAtmLocation(locationId);
    }



}
