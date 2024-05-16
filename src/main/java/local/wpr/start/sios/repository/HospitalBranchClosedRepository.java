package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalBranchClosed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBranchClosedRepository extends JpaRepository<HospitalBranchClosed, Long> {
}
