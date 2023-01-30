package ee.valiit.back_bank_27.bank;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.domain.user.UserMapperImpl;
import ee.valiit.back_bank_27.domain.user.UserService;
import jakarta.annotation.Resource;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapperImpl userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);

        User user1 = userService.findUser("rain", "123");
        User user2 = userService.findUser("rain", "123");
        User user3 = userService.findUser("rain", "123");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        userMapper.toDtos



        LoginResponse response = userMapper.toDto(user);
        return response;
    }

    private User getUserServiceUser() {
        return userService.findUser();
    }


}
