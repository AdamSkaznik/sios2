package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_messages__type")
public class MessagesType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messagesTypeId;
    private String messagesTypeName;
}
