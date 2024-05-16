package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Managment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagmentRepository extends JpaRepository<Managment, Long> {
}
