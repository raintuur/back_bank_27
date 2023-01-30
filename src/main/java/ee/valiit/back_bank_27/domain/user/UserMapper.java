package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;

public interface UserMapper {



    LoginResponse toDto (User user);

}
