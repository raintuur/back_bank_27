package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.infrastructure.exception.DataNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {

        Optional<User> optinalUser = userRepository.findByUsernameAndPassword(username, password);

        if (optinalUser.isEmpty()) {
            throw new DataNotFoundException("", "666");
        }

        return optinalUser.get();
    }
}
