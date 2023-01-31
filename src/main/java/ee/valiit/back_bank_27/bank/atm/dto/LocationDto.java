package ee.valiit.back_bank_27.bank.atm.dto;

import lombok.Data;

import java.util.List;

@Data
public class LocationDto {

    private Integer locationId;

    private String locationName;

    private String cityName;

    private List<TransactionTypeDto> transactionTypes;

}
