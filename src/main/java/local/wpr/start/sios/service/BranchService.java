package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> getAllBranch();
    Branch getBranchById(Long branchId);

    void saveBranch(Branch branch);
}
