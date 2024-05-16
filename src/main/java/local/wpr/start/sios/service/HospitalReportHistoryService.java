package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalReportHistory;

import java.util.List;

public interface HospitalReportHistoryService {
    List<HospitalReportHistory> getAll();
    List<HospitalReportHistory> getByHospital(Long id);
    HospitalReportHistory getById(Long id);
    void saveHospitalReportHistory(HospitalReportHistory hospitalReportHistory);

}
