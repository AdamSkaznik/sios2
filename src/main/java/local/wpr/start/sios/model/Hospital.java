package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalId;
    private String name;
    private String shortName;
    private String phone;
    private String fax;
    @Column(length = 4096)
    private String hospitalDescription;
    private int kolej;
    @ManyToOne
    @JoinColumn(name = "addressId", nullable = true)
    private Address address;
    @ManyToOne
    @JoinColumn(name = "hospitalCategoryId", nullable = false)
    private HospitalCategory hospitalCategory;
    @ManyToOne
    @JoinColumn(name = "hospitalCountyId", nullable = false)
    private HospitalCounty hospitalCounty;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "hospitalManagment", joinColumns = @JoinColumn(name = "hospitalId"), inverseJoinColumns = @JoinColumn(name = "managmentId"))
//    private Set<Managment> managments;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "hospitalBranch", joinColumns = @JoinColumn(name = "hospitalId"), inverseJoinColumns = @JoinColumn(name = "branchId"))
//    private Set<Branch> branches;
}
