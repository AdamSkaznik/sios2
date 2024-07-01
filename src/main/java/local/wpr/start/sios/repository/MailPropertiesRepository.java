package local.wpr.start.sios.repository;

import local.wpr.start.sios.model.MailProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MailPropertiesRepository extends JpaRepository<MailProperties, Long> {
    String zap = "SELECT * FROM tab_mail_properties WHERE active=true";
    @Query(value = zap, nativeQuery = true)
    MailProperties getProperties();
}
