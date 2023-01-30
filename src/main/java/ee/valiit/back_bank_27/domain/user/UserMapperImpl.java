package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;
import ee.valiit.back_bank_27.domain.user.role.Role;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponse toDto(User user) {
        // todo: votame Getteritefa vajalikud andmed ja paeme need Setteritega Dto objekti

        Integer userId = user.getId();
        Role role = user.getRole();

        String roleType = role.getType();

        LoginResponse response = new LoginResponse();
        response.setUserId(userId);
        response.setRoleType(roleType);

        return response;
    }
}
