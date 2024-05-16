package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalCountyRepository extends JpaRepository<HospitalCounty, Long> {
}
