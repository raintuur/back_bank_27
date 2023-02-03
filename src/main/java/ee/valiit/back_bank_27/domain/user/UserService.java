package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.bank.Status;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password, Status.ACTIVE);
        User user = Validator.getValidUser(optionalUser);
        return user;
    }

}
