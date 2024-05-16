package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalFailures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalFailuresRepository extends JpaRepository<HospitalFailures, Long> {
}
