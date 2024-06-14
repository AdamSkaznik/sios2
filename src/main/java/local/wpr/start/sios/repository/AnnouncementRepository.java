package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.Announcement;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    String zap = "SELECT * FROM tab_announcement WHERE announcement_active = true order by announcement_id DESC LIMIT 1";
    @Query(value = zap, nativeQuery = true)
    Announcement getLast();
}
