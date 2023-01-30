package ee.valiit.back_bank_27.domain.user;

public interface UserRepository {

    User findByUsernameAndPassword(String username, String password);

    User findById(Integer userId);




}
