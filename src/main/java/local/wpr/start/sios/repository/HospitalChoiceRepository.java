package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalChoiceRepository extends JpaRepository<HospitalChoice, Long> {
}
