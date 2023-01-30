package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public LoginResponse userToLoginResponse(User user) {
        return null;
    }

    @Override
    public LoginResponse toDto(User user) {
        return null;
    }
}
