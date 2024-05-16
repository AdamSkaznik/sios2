package local.wpr.start.sios.service;

import local.wpr.start.sios.model.HospitalCategory;

import java.util.List;

public interface HospitalCategoryService {
    List<HospitalCategory> getAllHospitalCategory();
    HospitalCategory getHospitalCategoryById(Long hospitalCategoryId);

    void saveHospitalCategory(HospitalCategory hospitalCategory);
}
