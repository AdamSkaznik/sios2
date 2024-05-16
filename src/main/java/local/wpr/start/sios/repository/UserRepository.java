package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    String zap = "SELECT * FROM tab_users WHERE user_name = ?1";
    @Query(value = zap, nativeQuery = true)
    User findByUserName(String userName);
    List<User> findAll();
    User findById(Integer userId);

//    String zapHospital = "SELECT * FROM tab_users WHERE "

}
