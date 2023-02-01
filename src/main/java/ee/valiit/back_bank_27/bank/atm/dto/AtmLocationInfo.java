package ee.valiit.back_bank_27.bank.atm.dto;

import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import lombok.Data;

import java.util.List;

@Data
public class AtmLocationInfo {
    private Integer cityId;
    private String locationName;
    private Integer numberOfAtms;
    private String picture;

    private List<TransactionTypeInfo> transactionTypes;

}
