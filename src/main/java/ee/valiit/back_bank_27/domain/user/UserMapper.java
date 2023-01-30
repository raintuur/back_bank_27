package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;

public interface UserMapper {

    LoginResponse userToLoginResponse(User user);

   LoginResponse toDto(User user);
}
