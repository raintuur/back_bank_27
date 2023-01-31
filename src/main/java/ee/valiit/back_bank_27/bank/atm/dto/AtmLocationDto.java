package ee.valiit.back_bank_27.bank.atm.dto;

import ee.valiit.back_bank_27.domain.location.Location;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Location} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmLocationDto implements Serializable {
    private Integer locationId;

    @Size(max = 255)
    @NotNull
    private String cityName;

    @Size(max = 255)
    @NotNull
    private String locationName;

    private List<TransactionTypeDto> transactionTypes;
}