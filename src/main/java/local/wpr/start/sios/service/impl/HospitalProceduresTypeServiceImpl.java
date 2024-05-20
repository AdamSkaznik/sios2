package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalProceduresType;
import local.wpr.start.sios.repository.HospitalProceduresTypeRepository;
import local.wpr.start.sios.service.HospitalProceduresTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalProceduresTypeServiceImpl implements HospitalProceduresTypeService {
    @Autowired
    HospitalProceduresTypeRepository hospitalProceduresTypeRepository;

    public HospitalProceduresTypeServiceImpl(HospitalProceduresTypeRepository hospitalProceduresTypeRepository) {
        this.hospitalProceduresTypeRepository = hospitalProceduresTypeRepository;
    }

    @Override
    public List<HospitalProceduresType> getAllProceruresType() {
        return hospitalProceduresTypeRepository.findAll();
    }

    @Override
    public void saveHospitalProceduresType(HospitalProceduresType hospitalProceduresType) {
            hospitalProceduresTypeRepository.save(hospitalProceduresType);
    }

    @Override
    public HospitalProceduresType getById(Long id) {
        return hospitalProceduresTypeRepository.getReferenceById(id);
    }
}
