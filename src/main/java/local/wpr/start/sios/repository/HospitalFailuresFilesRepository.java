package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalFailuresFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalFailuresFilesRepository extends JpaRepository<HospitalFailuresFiles, Long> {
}
