package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.MessagesFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesFilesRepository extends JpaRepository<MessagesFiles, Long> {
}
