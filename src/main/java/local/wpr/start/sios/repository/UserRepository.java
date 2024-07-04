package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    String zap = "SELECT * FROM tab_users WHERE user_name = ?1";
    @Query(value = zap, nativeQuery = true)
    User findByUserName(String userName);
    List<User> findAll();

    String zapUser = "SELECT * FROM tab_users where id = ?1";

//    @Query(value = zapUser, nativeQuery = true)
//    default User findById(Long id) {
//        ;
//    }

    //    User findById(Long id);
    String zap2 = "SELECT * FROM tab_users WHERE hospital_id = ?1";
    @Query(value = zap2, nativeQuery = true)
    List<User> findByHospitalId(Long id);

//    String zapWkrm = "select * from tab_users "

//    String zapHospital = "SELECT * FROM tab_users WHERE "

    String updatePassword = "UPDATE tab_users set password = ?1 where id = ?2";
    @Query(value = updatePassword, nativeQuery = true)
    User updatePassword(String password, Long id);

}
