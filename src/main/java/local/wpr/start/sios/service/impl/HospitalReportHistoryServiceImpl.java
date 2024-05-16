package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalReportHistory;
import local.wpr.start.sios.repository.HospitalReportHistoryRepository;
import local.wpr.start.sios.service.HospitalReportHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalReportHistoryServiceImpl implements HospitalReportHistoryService {
    @Autowired
    HospitalReportHistoryRepository hospitalReportHistoryRepository;

    public HospitalReportHistoryServiceImpl(HospitalReportHistoryRepository hospitalReportHistoryRepository) {
        this.hospitalReportHistoryRepository = hospitalReportHistoryRepository;
    }

    @Override
    public List<HospitalReportHistory> getAll() {
        return hospitalReportHistoryRepository.findAll();
    }

    @Override
    public List<HospitalReportHistory> getByHospital(Long id) {
        return hospitalReportHistoryRepository.getAllByHospital(id);
    }

    @Override
    public HospitalReportHistory getById(Long id) {
        return hospitalReportHistoryRepository.getReferenceById(id);
    }

    @Override
    public void saveHospitalReportHistory(HospitalReportHistory hospitalReportHistory) {
        hospitalReportHistoryRepository.save(hospitalReportHistory);
    }
}
