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
        //TODO: võtame Getteritega vajalikud andmed ja paneme need Setteritega Dto objekti

        Integer userId = user.getId();

        Role role = user.getRole();

        String roleType = role.getType();

        LoginResponse response = new LoginResponse();
        response.setUserId(userId);
        response.setRoleType(roleType);

        return response;
    }

    @Override
    public List<LoginResponse> toDto(List<User> users) {

        List<LoginResponse> responses = new ArrayList<>();

        for (User user : users) {

            responses.add(toDto(user));

        }


        return responses;
    }

    private static List<User> getUsers(List<User> users) {
        return users;
    }
}
