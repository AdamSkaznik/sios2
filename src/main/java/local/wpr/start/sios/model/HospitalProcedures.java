package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_procedures")
public class HospitalProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalProceduresId;
    private String name;
    @Column(length = 4096)
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime localDateTime;
    private boolean procedureActive;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
