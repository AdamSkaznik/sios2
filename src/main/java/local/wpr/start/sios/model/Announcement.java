package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementId;
    private String announcementTitle;
    @Column(length = 4096)
    private String announcementContent;
    private Date dataOd;
    private Date dataDo;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    private boolean announcementActive;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "announcementUser", joinColumns = @JoinColumn(name = "announcementId"), inverseJoinColumns = @JoinColumn(name = "userId"))
//    private Set<User> users;
}
