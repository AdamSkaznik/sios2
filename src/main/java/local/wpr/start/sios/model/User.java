package local.wpr.start.sios.model;

//import jakarta.persistence.*;
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
@Table(name = "tab_users")
public class User {
    private static final long PASSWORD_EXPIRATION_TIME = 30L * 24L * 60L * 1000L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private Boolean active;
    private String firstName;
    private String lastName;
    @Column(name = "password_changed_time")
    private Date passwordChangedTime;
    @Transient
    private int role_tmp;
    @Transient
    private String password_tmp;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = true)
    private Hospital hospital;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "user_branch", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
//    private Set<Branch> branches;

    public boolean isPasswordExpired(){
        if(this.passwordChangedTime == null) return false;
        long currentTime = System.currentTimeMillis();
        long lastChangedTime = this.passwordChangedTime.getTime();
        return currentTime > lastChangedTime + PASSWORD_EXPIRATION_TIME;
    }
}
