package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalReportRespository extends JpaRepository<HospitalReport, Long> {

  String zap = "SELECT * FROM tab_hospital_report WHERE report_id = ?1";
  @Query(value = zap, nativeQuery = true)
    List<HospitalReport> getByReportId(Long reportId);

  String zap_zm1 = "SELECT * FROM tab_hospital_report WHERE report_id = ?1 AND statea_1 is null";
  @Query(value = zap_zm1, nativeQuery = true)
  List<HospitalReport> getByNullZmiany1(Long reportId);

  String zap_zm2 = "SELECT * FROM tab_hospital_report WHERE report_id = ?1 AND stateb_1 is null";
  @Query(value = zap_zm2, nativeQuery = true)
  List<HospitalReport> getByNullZmiany2(Long reportId);

  String zap_zm3 = "SELECT * FROM tab_hospital_report WHERE report_id = ?1 AND statec_1 is null";
  @Query(value = zap_zm1, nativeQuery = true)
  List<HospitalReport> getByNullZmiany3(Long reportId);

  String zapByHospitalAndDate = "SELECT * FROM tab_hospital_report WHERE report_id = ?1 AND hospital_id = ?2";
  @Query(value = zapByHospitalAndDate, nativeQuery = true)
  List<HospitalReport> getAllByHospitalIdAndReportId(Long reportId, Long hospitalId);

//  String updateById = "UPDATE tab_hospital_report"
}
