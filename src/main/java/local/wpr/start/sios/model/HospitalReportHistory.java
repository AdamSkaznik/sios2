package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_report_history")
public class HospitalReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalReportHistoryId;
    @Column(length = 12288)
    private String hospitalReportHistoryDescription;
    @ManyToOne
    @JoinColumn(name = "hospitalReportId", nullable = false)
    private HospitalReport hospitalReport;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = true)
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "hospitalConfigId", nullable = true)
    private HospitalConfig hospitalConfig;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime createDate;
}
