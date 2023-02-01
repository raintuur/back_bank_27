package ee.valiit.back_bank_27.domain.location.transaction;

import ee.valiit.back_bank_27.bank.atm.dto.TransactionTypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationTransactionMapper {

    @Mapping(source = "transaction.type", target = "typeName")
    TransactionTypeDto toDto(LocationTransaction locationTransaction);

    List<TransactionTypeDto> toDtos(List<LocationTransaction> locationTransactions);
}