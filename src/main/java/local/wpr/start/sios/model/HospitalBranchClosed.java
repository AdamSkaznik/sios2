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
    @OneToMany(mappedBy = "hospitalBranchClosed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HospitalBranchClosedFiles> hospitalBranchClosedFiles  = new ArrayList<>();
    @Transient
    private String dStart;
    @Transient
    private String dEnd;
    @Transient
    private boolean attachment;
}
