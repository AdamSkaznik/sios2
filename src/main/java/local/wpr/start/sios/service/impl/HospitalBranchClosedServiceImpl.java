package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalBranchClosed;
import local.wpr.start.sios.repository.HospitalBranchClosedRepository;
import local.wpr.start.sios.service.HospitalBranchClosedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalBranchClosedServiceImpl implements HospitalBranchClosedService {
    @Autowired
    HospitalBranchClosedRepository hospitalBranchClosedRepository;

    public HospitalBranchClosedServiceImpl(HospitalBranchClosedRepository hospitalBranchClosedRepository) {
        this.hospitalBranchClosedRepository = hospitalBranchClosedRepository;
    }

    @Override
    public List<HospitalBranchClosed> getAll() {
        return hospitalBranchClosedRepository.findAll();
    }

    @Override
    public HospitalBranchClosed saveHospitalBranchClosed(HospitalBranchClosed hospitalBranchClosed) {
        hospitalBranchClosedRepository.save(hospitalBranchClosed);
        return hospitalBranchClosed;
    }

    @Override
    public HospitalBranchClosed getById(Long id) {
        return hospitalBranchClosedRepository.getReferenceById(id);
    }

//    @Override
//    public saveHospitalBranchClosed(HospitalBranchClosed hospitalBranchClosed) {
//        hospitalBranchClosedRepository.save(hospitalBranchClosed);
//        return hospitalBranchClosed;
//        hospitalProceduresRepository.save(hospitalProcedures);
//        return hospitalProcedures;
//    }
}
