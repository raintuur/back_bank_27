package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;

import java.util.List;

public interface UserMapper {

    LoginResponse toDto(User user);


    List<LoginResponse> toDtos(List<User> users);

}
