package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Hospital;
import local.wpr.start.sios.repository.HospitalRepository;
import local.wpr.start.sios.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Long hospitalId) {
        return hospitalRepository.getReferenceById(hospitalId);
    }

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }
}
