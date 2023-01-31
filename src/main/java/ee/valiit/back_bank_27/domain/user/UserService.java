package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;
import ee.valiit.back_bank_27.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.valiit.back_bank_27.infrastructure.error.ErrorMessage.INCORRECT_CREDENTIALS;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        User user = Validator.getValidUser(optionalUser);


        return user;
    }
//        return optionalUser.get();
//        return Validator.getValidUser(optionalUser);

}
