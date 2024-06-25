package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//kierownictwo
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_managment")
public class Managment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long managmentId;
    private String managmentPerson;
    private String managmentPhone;
    private String managmentMobilePhone;
    private String managmentEmail;
    @Column(length = 4096)
    private String managmentDescription;
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @JoinTable(name = "managmentHospitals", joinColumns = @JoinColumn(name = "managmentId"), inverseJoinColumns = @JoinColumn(name = "hospitalConfigId"))
//    private Set<HospitalConfig> hospitalConfigs;

}
