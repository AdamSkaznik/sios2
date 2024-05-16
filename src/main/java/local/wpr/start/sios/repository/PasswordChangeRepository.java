package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.PasswordChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordChangeRepository extends JpaRepository<PasswordChange, Long> {
}
