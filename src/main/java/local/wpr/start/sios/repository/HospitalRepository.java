package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    String zap = "SELECT * FROM tab_hospital where hospital_active = true and name iLIKE %?1%";
    @Query(value = zap, nativeQuery = true)
    public List<Hospital> findByName(String name);
}
