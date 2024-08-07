package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_messages_files")
public class MessagesFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messagesFilesId;
    private String fileName;
    private String fileUrl;
//    @Column(length = 12288)
//    private String description;
    private boolean messageFileActive;
    @ManyToOne
    @JoinColumn(name = "messagesId", nullable = true)
    private Messages messages;

}
