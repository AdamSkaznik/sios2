package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

//model awarii oddziałów szpitalnych
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_failures")
public class HospitalFailures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalFailuresId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime dataOd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime dataDo;
    //opis
    @Column(length = 4096)
    private String description;
    //zabezpieczenia
    private String security;
    //oddział
    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;
    //szpital
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    // użytkownik zgłaszający
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "hospitalFailuresFiles", joinColumns = @JoinColumn(name = "hospitalFailuresId"), inverseJoinColumns = @JoinColumn(name = "messagesFileId"))
    private Set<MessagesFiles> messagesFiles;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="recipentHospitalFailures", joinColumns = @JoinColumn(name = "hospitalFailuresId"), inverseJoinColumns = @JoinColumn(name="hospitalId"))
    private Set<Hospital> hospitals;
}
