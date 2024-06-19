package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

//    String zap = "SELECT COUNT(*) FORM tab_messages WHERE "
    String zapMessages = "SELECT * FROM tab_messages WHERE messages_active = true and end_date >= now()";
    @Query(value = zapMessages, nativeQuery = true)
    List<Messages> getActive();
}
