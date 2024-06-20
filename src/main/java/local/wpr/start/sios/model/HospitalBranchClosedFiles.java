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
@Table(name = "tab_hospital_branch_closed_files")
public class HospitalBranchClosedFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalBranchClosedFilesId;
    @ManyToOne
    @JoinColumn(name = "hospitalBranchClosedId")
    private HospitalBranchClosed hospitalBranchClosed;
    private String fileName;
    private String fileUrl;
    private boolean fileActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime localDateTime;
}
