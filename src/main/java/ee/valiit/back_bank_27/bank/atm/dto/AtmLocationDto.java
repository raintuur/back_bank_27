package ee.valiit.back_bank_27.bank.atm.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.valiit.back_bank_27.domain.Location} entity
 */
@Data
public class AtmLocationDto implements Serializable {
    private final Integer LocationId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
    @Size(max = 255)
    @NotNull
    private final String LocationName;
}