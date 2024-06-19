package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalConfig;

import java.util.List;

public interface HospitalConfigService {
    List<HospitalConfig> getAllHospitalConfig();

    List<HospitalConfig> getAllByHospitalId(Long id);
    List<HospitalConfig> getAllActive();

    List<HospitalConfig> getIdAllActive();

    List<HospitalConfig> getAllToSelect();

    List<HospitalConfig> getByBranchName(Long hospitalId, String branchName);

    HospitalConfig getHospitalConfigById(Long hospitalConfigId);

    void saveHospitalConfig(HospitalConfig hospitalConfig);
    List<HospitalConfig> getByHospitalAndBranchName(Long hospitalId, String branchName);
}
