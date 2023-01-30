package ee.valiit.back_bank_27.domain.user;

public interface UserRepository {

    User findByUserNameAndPassword(String username, String password);

    User findById(Integer userId);
}
