package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalCounty;
import local.wpr.start.sios.repository.HospitalCountyRepository;
import local.wpr.start.sios.service.HospitalCountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalCountyServiceImpl implements HospitalCountyService {
    @Autowired
    HospitalCountyRepository hospitalCountyRepository;

    public HospitalCountyServiceImpl(HospitalCountyRepository hospitalCountyRepository) {
        this.hospitalCountyRepository = hospitalCountyRepository;
    }

    @Override
    public List<HospitalCounty> getAllHospitalCounty() {
        return hospitalCountyRepository.findAll();
    }

    @Override
    public HospitalCounty getHospitalCountyById(Long hospitalCountyId) {
        return hospitalCountyRepository.getReferenceById(hospitalCountyId);
    }

    @Override
    public void saveHospitalCounty(HospitalCounty hospitalCounty) {
        hospitalCountyRepository.save(hospitalCounty);
    }
}
