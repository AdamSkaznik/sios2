package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_procedures")
public class HospitalProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalProceduresId;
    private String name;
    @Column(length = 4096)
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime localDateTime;
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH24:mm:ss")
    private LocalDateTime modifiedDateTime;
    private boolean procedureActive;
    @ManyToOne
    @JoinColumn(name = "hospitalId", nullable = false)
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @OneToMany(mappedBy = "procedures", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HospitalProceduresFile> hospitalProceduresFiles = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "hospitalProceduresTypesId", nullable = true)
    private HospitalProceduresType hospitalProceduresType;
//    @OneToMany(mappedBy = "hospitalProceduresFile", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Document> documents;
}
