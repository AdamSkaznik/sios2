package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

//model awarii oddziałów szpitalnych
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_failures")
public class HospitalFailures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalFailuresId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private Date dataOd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private Date dataDo;
    @Transient
    private String dStart;
    @Transient
    private String dEnd;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime addDate;
    //opis
    @Column(length = 4096)
    private String description;
    //zabezpieczenia
    @Column(length = 4096)
    private String security;
    //oddział
//    @ManyToOne
//    @JoinColumn(name = "hospitalConfigId", nullable = false)
//    private HospitalConfig hospitalConfig;
    @ManyToOne
    @JoinColumn(name = "hospitalConfigId", nullable = false)
    private HospitalConfig hospitalConfig;
    //szpital
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    // użytkownik zgłaszający
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @OneToMany(mappedBy = "hospitalFailures", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HospitalFailuresFiles> hospitalFailuresFiles = new ArrayList<>();
//    @ManyToOne
//    @JoinColumn(name = "statusId", nullable = false)
//    private Status status;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "hospitalFailuresFiles", joinColumns = @JoinColumn(name = "hospitalFailuresId"), inverseJoinColumns = @JoinColumn(name = "hospitalFailuresFilesId"))
//    private Set<HospitalFailuresFiles> hospitalFailuresFiles;
    @Transient
    private boolean attachment;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name="recipentHospitalFailures", joinColumns = @JoinColumn(name = "hospitalFailuresId"), inverseJoinColumns = @JoinColumn(name="hospitalId"))
//    private Set<Hospital> hospitals;
}
