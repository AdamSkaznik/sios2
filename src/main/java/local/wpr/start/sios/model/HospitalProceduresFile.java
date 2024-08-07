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
@Table(name = "tab_hospital_procedures_file")
public class HospitalProceduresFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalProceduresFileId;
    @ManyToOne
    @JoinColumn(name = "hospitalProceduresId")
    private HospitalProcedures procedures;
    private String fileName;
    private String fileUrl;
//    private String fileUrl;
//    @Column(length = 4096)
//    private String description;
//    private int kolej;
    private boolean fileActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime localDateTime;
}
