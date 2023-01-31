package ee.valiit.back_bank_27.bank.atm.dto;

import ee.valiit.back_bank_27.domain.location.Location;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Location} entity
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

    private List<TransactionTypeDto> transactionTypes;
}