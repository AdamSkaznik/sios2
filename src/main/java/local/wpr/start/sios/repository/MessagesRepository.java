package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

//    String zap = "SELECT COUNT(*) FORM tab_messages WHERE "
}
