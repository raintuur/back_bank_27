package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.valiit.back_bank_27.validation.ErrorMessage.INCORRECT_CREDENTIALS;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> optinalUser = userRepository.findByUsernameAndPassword(username, password);
        User user = Validator.getValidUser(optinalUser);
        return user;
    }
}
