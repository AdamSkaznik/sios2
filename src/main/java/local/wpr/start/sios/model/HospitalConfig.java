package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_config")
public class HospitalConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalConfigId;
    // ogólna ilość łóżek
    private int numberOfBeds;
    // ilość łóżek zablokowanych do dyspozycji szpitala
    private int numberOfBedsLocked;
    @Column(length = 4096)
    private String hospitalConfigDescription;
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "hospitalConfigManagment", joinColumns = @JoinColumn(name = "hospitalConfigId"), inverseJoinColumns = @JoinColumn(name = "managmentId"))
//    private Set<Managment> managments;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;
    private boolean active;
    @CreatedDate
    private LocalDateTime createDate;
//    @Modifying(clearAutomatically = true, flushAutomatically = true)
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User createdUser;
//    @ManyToOne
//    @JoinColumn(name = "userId", nullable = true)
//    private User updateUser;

}
