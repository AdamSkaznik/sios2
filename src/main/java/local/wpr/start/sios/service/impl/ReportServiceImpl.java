package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.repository.ReportRepository;
import local.wpr.start.sios.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);
    @Autowired
    ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report getLastReport() {
        return reportRepository.getLastReport();
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.getAll();
    }

    @Override
    public List<Report> getAllArchived() {
        return reportRepository.getAllArchived();
    }

    @Override
    public List<Report> getById(Long reportId) {
        return (List<Report>) reportRepository.getById(reportId);
    }

    @Override
    public Report getOneReportById(Long id) {
        return reportRepository.getReferenceById(id);
    }

    @Override
    public Report getReportByDate(LocalDate date) {
        return reportRepository.getReportByDate(date);
    }

    @Override
    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public Report getByActualDate() {
        return reportRepository.getReportByActualDate();
    }

    @Override
    public Report getByNextDay() {
        System.out.println("Dzisiejsza data : " + new Date());
        return reportRepository.getReportByNextDay();
    }

    @Override
    public Report getCountByNextDay() {
        return reportRepository.getReportByNextDayCount();
    }
//
//    @Override
//    public Report getLast() {
//        return reportRepository.findTopByOrderByIdDesc();
//    }


//    @Scheduled(cron="20 9 * * * ?")
//    public void newReportsJob(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now = new Date();
//        String strDate = sdf.format(now);
//        System.out.println("Jesem tutaj ... Generowanie raportu dla daty: " + strDate);
//        try {
//            Report report = new Report();
//            report.setDate(now);
//            reportRepository.save(report);
//            LOG.info("Poprawnie założono nowy raport dla daty: " + strDate);
//        } catch (Exception e){
//         LOG.error("Nie udało się założyć nowego raportu dla szpitali, dla daty: " + strDate + " z powodu błędu: " + e.getMessage());
//        }
//    }
}
