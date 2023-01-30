package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    LoginResponse toDto(User user);

}