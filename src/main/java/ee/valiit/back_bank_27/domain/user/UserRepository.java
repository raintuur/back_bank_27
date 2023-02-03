package ee.valiit.back_bank_27.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.status = ?1 and u.password = ?2 and u.status = ?3")
    Optional<User> findUser(String status, String password, String status1);

}