package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Hospital;
import local.wpr.start.sios.model.HospitalReport;

import java.util.List;

public interface HospitalReportService {
    HospitalReport getById(Long id);

    void saveHospitalReport(HospitalReport hospitalReport);
    List<HospitalReport> getAllByReportId(Long id);
    List<HospitalReport> getNullByZmiana1(Long id);
    List<HospitalReport> getNullByZmiana2(Long id);
    List<HospitalReport> getNullByZmiana3(Long id);
}
