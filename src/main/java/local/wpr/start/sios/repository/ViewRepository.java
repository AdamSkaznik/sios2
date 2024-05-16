package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepository extends JpaRepository<Views, Long> {

    String zap_wkrm = "SELECT * FROM v_hospital_wkrm where report_id=?1";
    @Query(value = zap_wkrm, nativeQuery = true)
    List<Views> findAllWkrm(Long id);


}
