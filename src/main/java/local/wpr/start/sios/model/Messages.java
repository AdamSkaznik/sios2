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
@Table(name = "tab_messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messagesId;
    private Date addDate;
    private Date endDate;
    private boolean isAll;
    private String title;
    @Column(length = 12288)
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
//    @ManyToOne
//    @JoinColumn(name = "messageTypeId", nullable = false)
//    private MessagesType messagesType;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "messages_hospitalConfig", joinColumns = @JoinColumn(name = "messages_id"), inverseJoinColumns = @JoinColumn(name = "hospitalConfigId"))
    private Set<HospitalConfig> hospitalConfigs;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "messagesFile", joinColumns = @JoinColumn(name = "messagesId"), inverseJoinColumns = @JoinColumn(name = "messagesFileId"))
    private Set<MessagesFiles> messagesFiles;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "recipentMessages", joinColumns = =@JoinColumn(name = "messagesId"), inverseJoinColumns = )
}
