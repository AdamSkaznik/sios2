package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_private_message")
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privateMessageId;
    private Date addDate;
    private Date dateEnd;
    private String title;
    @Column(length = 12288)
    private String content;
    private boolean isRead;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "privateMessages", joinColumns = @JoinColumn(name = "privateMessageId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;
}
