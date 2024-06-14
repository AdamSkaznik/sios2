package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tab_admin_messages")
public class AdminMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminMessagesId;
    private String adminMessagesTitle;
    private String adminMessagesDesc;
    private boolean adminMessagesActive;
    @CreatedDate
    private LocalDateTime createDateTime;
    @CreatedBy
    private String user;
}
