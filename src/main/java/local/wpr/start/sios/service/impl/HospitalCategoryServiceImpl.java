package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalCategory;
import local.wpr.start.sios.repository.HospitalCategoryRepository;
import local.wpr.start.sios.service.HospitalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalCategoryServiceImpl implements HospitalCategoryService {
    @Autowired
    HospitalCategoryRepository hospitalCategoryRepository;

    public HospitalCategoryServiceImpl(HospitalCategoryRepository hospitalCategoryRepository) {
        this.hospitalCategoryRepository = hospitalCategoryRepository;
    }

    @Override
    public List<HospitalCategory> getAllHospitalCategory() {
        return hospitalCategoryRepository.findAll();
    }

    @Override
    public HospitalCategory getHospitalCategoryById(Long hospitalCategoryId) {
        return hospitalCategoryRepository.getReferenceById(hospitalCategoryId);
    }

    @Override
    public void saveHospitalCategory(HospitalCategory hospitalCategory) {
            hospitalCategoryRepository.save(hospitalCategory);
    }
}
