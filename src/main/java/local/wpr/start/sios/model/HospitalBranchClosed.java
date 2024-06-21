package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_branch_closed")
public class HospitalBranchClosed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //data od
    private Date dateFrom;
    // data do
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    //temat
    @Column(length = 1024)
    private String title;
    //przyczyna
    @Column(length = 4096)
    private String cause;
    //zastępstwo
    @Column(length = 4096)
    private String replacement;
    //zgoda wojewody
    private boolean agreement;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "hospitalConfigId", nullable = false)
    private HospitalConfig hospitalConfig;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "hospitalBranchClosedFiles", joinColumns = @JoinColumn(name = "hospitalBranchClosedId"), inverseJoinColumns = @JoinColumn(name = "messagesFileId"))
    private Set<MessagesFiles> messagesFiles;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="recipentHospitalBranchClosed", joinColumns = @JoinColumn(name = "hospitalBranchClosedId"), inverseJoinColumns = @JoinColumn(name="hospitalId"))
    private Set<Hospital> hospitals;
    @Transient
    private String dStart;
    @Transient
    private String dEnd;
    @Transient
    private boolean attachment;
}
