package ee.valiit.back_bank_27.bank.atm.dto;

import lombok.Data;

@Data
public class TransactionTypeInfo  {
    private Integer typeId;
    private String typeName;
    private Boolean isSelected;
}
