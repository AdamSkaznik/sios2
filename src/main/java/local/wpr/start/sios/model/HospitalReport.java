package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospitalReport")
public class HospitalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalReportId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospitalId", nullable = true)
    private Hospital hospital;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospitalConfigId", nullable = true)
    private HospitalConfig hospitalConfig;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    private int doctorA;
    private int stateA;
    private String stateA_1;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime stateADate;
    private int stateB;
    private String stateB_1;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime stateBDate;
    private int stateC;
    private String stateC_1;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime stateCDate;
//    private boolean isAccepted;
//    planowanych przyjęć
    private int plannedPartiesA;
    private int plannedPartiesB;
    private int plannedPartiesC;
    //zrealizowanych przyjęć
    private int completedAdmissionsA;
    private int completedAdmissionsB;
    private int completedAdmissionsC;
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime updateDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reportId", nullable = true)
    private Report report;
}
