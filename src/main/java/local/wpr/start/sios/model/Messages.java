package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messagesId;
    private LocalDateTime addDate;
    private Date startDate;
    private Date endDate;
    private boolean messagesActive;
    private String title;
    @Column(length = 12288)
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = true)
    private Hospital hospital;
    @Transient
    private String dStart;
    @Transient
    private String dEnd;
    @OneToMany(mappedBy = "messages", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MessagesFiles> messagesFiles = new ArrayList<>();


}
