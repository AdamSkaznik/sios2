package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalBranchClosedFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBranchClosedFilesRepository extends JpaRepository<HospitalBranchClosedFiles, Long> {
}
