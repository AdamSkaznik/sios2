package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalBranchClosed;

import java.util.List;

public interface HospitalBranchClosedService {
    List<HospitalBranchClosed> getAll();
    void saveHospitalBranchClosed (HospitalBranchClosed hospitalBranchClosed);
}
