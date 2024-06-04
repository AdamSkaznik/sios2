package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalProceduresType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalProceduresTypeRepository extends JpaRepository<HospitalProceduresType, Long> {
    String zapSearch = "SELECT * FROM tab_hospital_procedures_type where hospital_procedures_type_desc iLIKE %?1%";
    @Query(value = zapSearch, nativeQuery = true)
    public List<HospitalProceduresType> findByIgnoreCase(String description);
}
