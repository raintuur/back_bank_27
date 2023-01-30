package ee.valiit.back_bank_27.bank;

import ee.valiit.back_bank_27.domain.user.User;
import ee.valiit.back_bank_27.domain.user.UserMapperImpl;
import ee.valiit.back_bank_27.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.*;

@Service
public class LoginService {

    @Resource
    private UserService userService;
    @Resource
    private UserMapperImpl userMapper;

    public LoginResponse login(String username, String password) {

        User user = userService.findUser(username, password);

        LoginResponse response = userMapper.toDto(user);

        return response;
    }


}
