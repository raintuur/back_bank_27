package ee.valiit.back_bank_27.bank.atm.dto;

import ee.valiit.back_bank_27.domain.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Integer cityId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
}