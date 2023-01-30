package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.LoginResponse;
import ee.valiit.back_bank_27.domain.user.role.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public LoginResponse toDto(User user) {
        // TODO: võtame Getteritega vajalikud andmed ja paneme need Setteritega Dto objekti
        Integer userId = user.getId();

        String roleType = user.getRole().getType();


        LoginResponse response = new LoginResponse();
        response.setUserId(userId);
        response.setRoleType(roleType);

        return response;
    }

    @Override
    public List<LoginResponse> toDtos(List<User> users) {
        List<LoginResponse> responses = new ArrayList<>();

        for (
                User user :
                users
        ) {
            LoginResponse response = toDto(user);
            responses.add(response);
        }

        return responses;
    }
}
