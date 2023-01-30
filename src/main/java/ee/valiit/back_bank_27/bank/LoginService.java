package ee.valiit.back_bank_27.bank;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;


    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        //        to be implemented

        return null;
    }
}
