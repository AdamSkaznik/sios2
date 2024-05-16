package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserViewRepository extends JpaRepository<UserView, Long> {
    String zap_view = "SELECT * FROM v_hospital_view where report_id=?1";
    @Query(value = zap_view, nativeQuery = true)
     List<UserView> getAll(Long id);
}
