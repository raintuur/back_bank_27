package ee.valiit.back_bank_27.bank.login;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.domain.user.UserMapper;
import ee.valiit.back_bank_27.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        LoginResponse response = userMapper.toDto(user);
        return response;
    }



}
