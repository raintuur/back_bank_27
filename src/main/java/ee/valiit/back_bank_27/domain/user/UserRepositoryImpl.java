package ee.valiit.back_bank_27.domain.user;


import ee.valiit.back_bank_27.domain.user.role.Role;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public User findByUserNameAndPassword(String username, String password) {

        User user = createUserExaple();

        return user;
    }

    @Override
    public User findById(Integer userId) {
        User user = createUserExaple();

        return user;
    }

    private static User createUserExaple() {
        Role role =  new Role(1,"admin");

        User user = new User();
        user.setId(3);
        user.setUsername("roby");
        user.setPassword("123");
        user.setStatus("A");
        user.setRole(role);
        return user;
    }
}
