package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalProcedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalProceduresRepository extends JpaRepository<HospitalProcedures, Long> {
    String zap = "select * from tab_hospital_procedures where hospital_procedures_types_id in(1,2) or hospital_id = ?1";
    @Query(value = zap, nativeQuery = true)
    List<HospitalProcedures> findAllByHospital(Long id);
}
