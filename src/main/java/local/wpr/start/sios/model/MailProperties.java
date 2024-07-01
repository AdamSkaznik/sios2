package local.wpr.start.sios.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tab_mailProperties")
public class MailProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String host;
    private String userName;
    private String password;
    private int port;
    private boolean active;
}
