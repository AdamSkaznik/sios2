package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Report;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    Report getLastReport();
    List<Report> getAll();

    List<Report> getAllArchived();
    List<Report> getById(Long reportId);

    Report getOneReportById(Long id);

    Report getReportByDate(LocalDate date);

    void saveReport(Report report);

    Report getByActualDate();

    Report getByNextDay();
    Report getCountByNextDay();

//    Report getLast();
}
