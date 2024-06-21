package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalBranchClosedFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBranchClosedFilesRepository extends JpaRepository<HospitalBranchClosedFiles, Long> {
    String zap = "SELECT COUNT(*) FROM tab_hospital_branch_closed_files WHERE file_name =?1";
    @Query(value = zap, nativeQuery = true)
    int countFiles(String fileName);
}
