package ee.valiit.back_bank_27.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        return user;
    }

}
