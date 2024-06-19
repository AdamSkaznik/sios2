package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.repository.HospitalConfigReporitory;
import local.wpr.start.sios.service.HospitalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
public class HospitalConfigServiceimpl implements HospitalConfigService {
    @Autowired
    HospitalConfigReporitory hospitalConfigReporitory;

    public HospitalConfigServiceimpl(HospitalConfigReporitory hospitalConfigReporitory) {
        this.hospitalConfigReporitory = hospitalConfigReporitory;
    }

    @Override
    public List<HospitalConfig> getAllHospitalConfig() {
        return hospitalConfigReporitory.findAll();
    }

//    @Override
//    public List<HospitalConfig> gehAllByHospitalId(Long id) {
//        return null;
//    }

    @Override
    public List<HospitalConfig> getAllByHospitalId(Long hospitalId) {
        return hospitalConfigReporitory.findAllByHospitalId(hospitalId);
    }
    @Transactional
    @Override
    public List<HospitalConfig> getAllActive() {
        return hospitalConfigReporitory.getAllActive();
    }

    @Override
    public List<HospitalConfig> getIdAllActive() {
        return hospitalConfigReporitory.getIdAllActive();
    }

    @Override
    public List<HospitalConfig> getAllToSelect() {
        return hospitalConfigReporitory.getAllToSelect();
    }

    @Override
    public List<HospitalConfig> getByBranchName(Long hospitalId, String branchName) {
        return hospitalConfigReporitory.findByBranchName(hospitalId, branchName);
    }


    @Override
    public HospitalConfig getHospitalConfigById(Long hospitalConfigId) {
        return hospitalConfigReporitory.getReferenceById(hospitalConfigId);
    }

    @Override
    public void saveHospitalConfig(HospitalConfig hospitalConfig) {
        hospitalConfigReporitory.save(hospitalConfig);
    }

    @Override
    public List<HospitalConfig> getByHospitalAndBranchName(Long hospitalId, String branchName) {
        return hospitalConfigReporitory.getConfigByNameBranch(hospitalId, branchName);
    }


}
