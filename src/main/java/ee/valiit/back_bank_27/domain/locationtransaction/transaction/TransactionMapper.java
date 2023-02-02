package ee.valiit.back_bank_27.domain.locationtransaction.transaction;

import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "id", target = "typeId")
    @Mapping(source = "type", target = "typeName")
    @Mapping(source = "", target = "isSelected")
    TransactionTypeInfo toDto(Transaction transaction);

    void toInfos(List<Transaction> transactions);
}