package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalFailuresFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalFailuresFilesRepository extends JpaRepository<HospitalFailuresFiles, Long> {

    String zap = "SELECT COUNT(*) FROM tab_hospital_failures_files WHERE file_name =?1";
    @Query(value = zap, nativeQuery = true)
    int countFiles(String fileName);
}
