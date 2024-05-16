package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.PasswordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

//    String zapHistory = "SELECT * from tab_"
}
