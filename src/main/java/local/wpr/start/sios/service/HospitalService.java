package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospital();
    Hospital getHospitalById(Long hospitalId);

    void saveHospital(Hospital hospital);
}
