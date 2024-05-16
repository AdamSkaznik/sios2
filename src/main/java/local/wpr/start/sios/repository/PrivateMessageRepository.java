package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.PrivateMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Long> {
    String zapCount="SELECT COUNT(*) FROM tab_private_message p join private_messages pm on(p.private_message_id = pm.private_message_id) left join tab_users u on (pm.user_id = u.user_id) where u.user_id = ?1 and p.is_read = false";
    @Query(value = zapCount, nativeQuery = true)
    int countPrivateMessages(Long userId);

    String zapMess="SELECT p.* FROM tab_private_message p join private_messages pm on(p.private_message_id = pm.private_message_id) left join tab_users u on (pm.user_id = u.user_id) where u.user_id = ?1 and p.is_read = false";
    @Query(value = zapMess, nativeQuery = true)
    PrivateMessage getPrivateMessage(Long userId);
}
