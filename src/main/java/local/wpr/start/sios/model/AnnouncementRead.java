package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_announcement_read")
public class AnnouncementRead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementReadId;

}
