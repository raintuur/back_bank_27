package ee.valiit.back_bank_27.domain.locationtransaction;

import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeDto;
import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationTransactionMapper {

    @Mapping(source = "transaction.type", target = "typeName")
    TransactionTypeDto toDtos(LocationTransaction locationTransaction);

    List<TransactionTypeDto> toDtos(List<LocationTransaction> locationTransaction);

    @Mapping(source = "transaction.type", target = "typeName")
    @Mapping(source = "transaction.id", target = "typeId")
    @Mapping(source = "available", target = "isSelected")
    TransactionTypeInfo toInfo(LocationTransaction locationTransaction);
    List<TransactionTypeInfo> toInfos(List<LocationTransaction> locationTransactions);

}