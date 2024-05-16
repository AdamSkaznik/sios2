package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalFailures;

import java.util.List;

public interface HospitalFailuresService {
    List<HospitalFailures> getAllHospitalFailures();

    HospitalFailures getHospitalFailuresById(Long hospitalFailuresId);

    void saveHospitalFailures(HospitalFailures hospitalFailures);
}
