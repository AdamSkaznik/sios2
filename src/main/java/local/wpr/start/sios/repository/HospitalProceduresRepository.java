package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.HospitalProcedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalProceduresRepository extends JpaRepository<HospitalProcedures, Long> {
}
