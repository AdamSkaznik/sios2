package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_failures_files")
public class HospitalFailuresFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalFailuresFilesId;
    @ManyToOne
    @JoinColumn(name = "hospitalFailuresId")
    private HospitalFailures hospitalFailures;
    private String filename;
    private String fileUrl;
    private boolean fileActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime localDateTime;
}
