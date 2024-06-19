package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.ViewHospitalBranchSearch;
import local.wpr.start.sios.repository.ViewHospitalBranchSearchRepository;
import local.wpr.start.sios.service.ViewHospitalBranchSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewHospitalBranchSearchServiceImpl implements ViewHospitalBranchSearchService {
    @Autowired
    ViewHospitalBranchSearchRepository viewHospitalBranchSearchRepository;

    public ViewHospitalBranchSearchServiceImpl(ViewHospitalBranchSearchRepository viewHospitalBranchSearchRepository) {
        this.viewHospitalBranchSearchRepository = viewHospitalBranchSearchRepository;
    }

    @Override
    public List<ViewHospitalBranchSearch> getAllBranchSearch(Long id) {
        return viewHospitalBranchSearchRepository.getSearch(id);
    }
}
