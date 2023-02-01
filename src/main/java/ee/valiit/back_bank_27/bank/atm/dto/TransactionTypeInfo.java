package ee.valiit.back_bank_27.bank.atm.dto;

import lombok.Data;

@Data
public class TransactionTypeInfo extends TransactionTypeDto {
    private Integer typeId;
    private Boolean isSelected;
}
