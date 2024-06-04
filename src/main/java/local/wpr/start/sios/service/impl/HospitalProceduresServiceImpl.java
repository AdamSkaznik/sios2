package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalProcedures;
import local.wpr.start.sios.repository.HospitalProceduresRepository;
import local.wpr.start.sios.service.HospitalProceduresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalProceduresServiceImpl implements HospitalProceduresService {
    @Autowired
    HospitalProceduresRepository hospitalProceduresRepository;

    public HospitalProceduresServiceImpl(HospitalProceduresRepository hospitalProceduresRepository) {
        this.hospitalProceduresRepository = hospitalProceduresRepository;
    }

    @Override
    public HospitalProcedures saveHospitalProcedures(HospitalProcedures hospitalProcedures) {
        hospitalProceduresRepository.save(hospitalProcedures);
        return hospitalProcedures;
    }

    @Override
    public List<HospitalProcedures> getAllHospitalProcedures() {
        return hospitalProceduresRepository.findAll();
    }

    @Override
    public HospitalProcedures getHospitalProceduresById(Long hospitalProceduresId) {
        return hospitalProceduresRepository.getReferenceById(hospitalProceduresId);
    }
}
