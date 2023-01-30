package ee.valiit.back_bank_27.domain.user;

import ee.valiit.back_bank_27.domain.user.role.Role;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = createUserExample();
        return user;
    }
    @Override
    public User findById(Integer userId) {
        User userExample = createUserExample();
        return userExample;
    }

    private static User createUserExample() {
        Role role = new Role(1, "admin");
        User user = new User();
        user.setId(2);
        user.setUsername("triin");
        user.setPassword("123");
        user.setStatus("A");
        user.setRole(role);
        return user;
    }
}
