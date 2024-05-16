package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_password_change")
public class PasswordChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passwordChangeId;
    @CreatedDate
    private Date createdDate;
    private Date lastChange;
    private Date mustChange;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "password_history", joinColumns = @JoinColumn(name = "password_change_id"), inverseJoinColumns = @JoinColumn(name = "password_history_id"))
    private Set<PasswordHistory> passwordHistories = new HashSet<>();
}
