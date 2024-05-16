package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.LogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTypeReporitory extends JpaRepository<LogType, Integer> {
}
