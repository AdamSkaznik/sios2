package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Branch;
import local.wpr.start.sios.repository.BranchRepository;
import local.wpr.start.sios.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long branchId) {
        return branchRepository.getReferenceById(branchId);
    }

    @Override
    public void saveBranch(Branch branch) {
        branchRepository.save(branch);
    }
}
