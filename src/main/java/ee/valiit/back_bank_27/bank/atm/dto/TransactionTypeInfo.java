package ee.valiit.back_bank_27.bank.atm.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class TransactionTypeInfo {

    private Integer typeId;

    private String typeName;

    private Boolean isSelected;

}
