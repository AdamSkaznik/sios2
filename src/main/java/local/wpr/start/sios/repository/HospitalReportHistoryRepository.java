package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalReportHistoryRepository extends JpaRepository<HospitalReportHistory, Long> {

    String zap = "SELECT * FROM tab_hospital_report_history where hospitalId = ?1";
    @Query(value = zap, nativeQuery = true)
    List<HospitalReportHistory> getAllByHospital(Long id);
}
