package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    String zap1 = "SELECT * FROM tab_reports ORDER BY date DESC LIMIT 1";
    @Query(value = zap1, nativeQuery = true)
    Report getLastReport();

    String zap2 = "SELECT * FROM tab_reports where date >= (select current_date - make_interval(months => 3)) ORDER BY date DESC";
    @Query(value = zap2, nativeQuery = true)
    List<Report> getAll();

    String zap3 = "select * from tab_reports where report_id =?1";
    @Query(value = zap3, nativeQuery = true)
    List<Report> getById(Report Long);

    String zap4 = "SELECT * FROM tab_reports WHERE date = ?1";
    @Query(value = zap4, nativeQuery = true)
    Report getReportByDate(LocalDate date);

    String zap5 = "SELECT * FROM tab_reports where date <= (select current_date - make_interval(months => 3)) ORDER BY date DESC";
    @Query(value = zap5, nativeQuery = true)
    List<Report> getAllArchived();

    String zapByDateNow = "SELECT * FROM tab_reports WHERE date(date) = date(current_timestamp)";
    @Query(value = zapByDateNow, nativeQuery = true)
    Report getReportByActualDate();

    String zapDateNext = "SELECT * FROM tab_reports WHERE date(date) = date(now() + interval '1 day')";
    @Query(value = zapDateNext, nativeQuery = true)
    Report getReportByNextDay();

    String zapCountNext = "SELECT COUNT(*) FROM tab_reports WHERE date(date) = date(now() + interval '1 day')";
    @Query(value = zapCountNext, nativeQuery = true)
    Report getReportByNextDayCount();
}
