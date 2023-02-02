package ee.valiit.back_bank_27.bank.atm.dto;

import lombok.Data;

@Data
public class TransactionTypeInfo

{

    private String typeName;
    private Integer typeId;
    private Boolean isSelected;
}
