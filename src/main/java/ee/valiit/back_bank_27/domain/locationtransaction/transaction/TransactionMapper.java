package ee.valiit.back_bank_27.domain.locationtransaction.transaction;

import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "id", target = "typeId")
    @Mapping(source = "type", target = "typeName")
    @Mapping(constant = "false", target = "isSelected")
    TransactionTypeInfo toInfo(Transaction transaction);

    List<TransactionTypeInfo> toInfos(List<Transaction> transactions);

}