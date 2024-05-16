package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalReport;
import local.wpr.start.sios.repository.HospitalReportRespository;
import local.wpr.start.sios.service.HospitalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalReportServiceImpl implements HospitalReportService {
    @Autowired
    HospitalReportRespository hospitalReportRespository;

    public HospitalReportServiceImpl(HospitalReportRespository hospitalReportRespository) {
        this.hospitalReportRespository = hospitalReportRespository;
    }

    @Override
    public HospitalReport getById(Long id) {
        return hospitalReportRespository.getReferenceById(id);
    }

    @Override
    public void saveHospitalReport(HospitalReport hospitalReport) {
        hospitalReportRespository.save(hospitalReport);
    }

    @Override
    public List<HospitalReport> getAllByReportId(Long id) {
        return hospitalReportRespository.getByReportId(id);
    }

    @Override
    public List<HospitalReport> getNullByZmiana1(Long id) {
        return hospitalReportRespository.getByNullZmiany1(id);
    }

    @Override
    public List<HospitalReport> getNullByZmiana2(Long id) {
        return hospitalReportRespository.getByNullZmiany2(id);
    }
    @Override
    public List<HospitalReport> getNullByZmiana3(Long id) {
        return hospitalReportRespository.getByNullZmiany3(id);
    }
}
