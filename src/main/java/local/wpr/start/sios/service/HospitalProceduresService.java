package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalProcedures;

import java.util.List;

public interface HospitalProceduresService {
    HospitalProcedures saveHospitalProcedures(HospitalProcedures hospitalProcedures);
    List<HospitalProcedures> getAllHospitalProcedures();

    HospitalProcedures getHospitalProceduresById(Long hospitalProceduresId);
}
