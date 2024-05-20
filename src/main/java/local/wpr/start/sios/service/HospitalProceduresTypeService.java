package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalProceduresType;

import java.util.List;

public interface HospitalProceduresTypeService {

    List<HospitalProceduresType> getAllProceruresType();
    void saveHospitalProceduresType(HospitalProceduresType hospitalProceduresType);

    HospitalProceduresType getById(Long id);
}
