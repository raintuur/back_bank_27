package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;
import ee.valiit.back_bank_27.domain.user.role.Role;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper{

    @Override
    public LoginResponse toDto(User user) {
        Integer userId = user.getId();
        Role role = user.getRole();

        String roleType = role.getType();


        LoginResponse response = new LoginResponse();
        response.setUserId(userId);
        response.setRoleType(roleType);
        return response;
    }
}
