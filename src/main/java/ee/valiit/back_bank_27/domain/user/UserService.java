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
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException("Vale kasutajanimi või parool", "666");
        }

        User user = optionalUser.get();
        return user;
    }

}
