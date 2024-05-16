package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalFailures;
import local.wpr.start.sios.repository.HospitalFailuresRepository;
import local.wpr.start.sios.service.HospitalFailuresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalFailuresServiceImpl implements HospitalFailuresService {
    @Autowired
    HospitalFailuresRepository hospitalFailuresRepository;

    public HospitalFailuresServiceImpl(HospitalFailuresRepository hospitalFailuresRepository) {
        this.hospitalFailuresRepository = hospitalFailuresRepository;
    }

    @Override
    public List<HospitalFailures> getAllHospitalFailures() {
        return hospitalFailuresRepository.findAll();
    }

    @Override
    public HospitalFailures getHospitalFailuresById(Long hospitalFailuresId) {
        return hospitalFailuresRepository.getReferenceById(hospitalFailuresId);
    }

    @Override
    public void saveHospitalFailures(HospitalFailures hospitalFailures) {
        hospitalFailuresRepository.save(hospitalFailures);
    }
}
