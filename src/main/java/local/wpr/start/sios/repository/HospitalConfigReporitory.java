package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalConfigReporitory extends JpaRepository<HospitalConfig, Long> {

    String zap = "SELECT * FROM tab_hospital_config WHERE hospital_id = ?1";
    @Query(value = zap, nativeQuery = true)
    List<HospitalConfig> findAllByHospitalId(Long id);

    String zapSearchBranch = "SELECT * FROM tab_hospital_config WHERE hospital_id = ?1 and branch.name iLike %?2%";
    @Query(value = zapSearchBranch, nativeQuery = true)
    public List<HospitalConfig> findByBranchName(Long id, String name);

    String zapAllActive = "SELECT * FROM tab_hospital_config WHERE active = true";
    @Query(value = zapAllActive, nativeQuery = true)
    public List<HospitalConfig> getAllActive();

    String zapIdAllActive = "SELECT hospital_config_id FROM tab_hospital_config WHERE active = true";
    @Query(value = zapIdAllActive, nativeQuery = true)
    List<HospitalConfig> getIdAllActive();

    String zapHospitalSelect = "SELECT a.* FROM tab_hospital_config a";
    @Query(value = zapHospitalSelect, nativeQuery = true)
    List<HospitalConfig>getAllToSelect();

//    String zapHospitalAddress = "select "
}
