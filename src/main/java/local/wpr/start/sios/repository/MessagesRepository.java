package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {

//    String zap = "SELECT COUNT(*) FORM tab_messages WHERE "
    String zapMessages = "SELECT * FROM tab_messages WHERE messages_active = true and end_date >= now()";
    @Query(value = zapMessages, nativeQuery = true)
    List<Messages> getActive();

//    String updateMessages = "UPDATE tab_messages SET content=:content, end_date=:endDate, messages_active=:messagesActive, start_date=startDate, title=:title, hospital_id=:hospitalId, user_id=userId where messages_id=:messagesId";
//    @Modifying(clearAutomatically = true)
//    @Query(value = updateMessages, nativeQuery = true)
//    void updateMessages(@Param("content")String content, @Param("endDate")Date endDate, @Param("messagesActive") Boolean messagesActive, @Param("startDate")Date startDate, @Param("title")String title, @Param("hospitalId") Long hospitalId, @Param("userId")Long userId, @Param("messagesId")Long messagesId);
}
