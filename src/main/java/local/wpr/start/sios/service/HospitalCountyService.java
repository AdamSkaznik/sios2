package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalCounty;

import java.util.List;

public interface HospitalCountyService {
    List<HospitalCounty> getAllHospitalCounty();
    HospitalCounty getHospitalCountyById(Long hospitalCountyId);

    void saveHospitalCounty(HospitalCounty hospitalCounty);
}
