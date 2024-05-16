package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//oddział
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code;
    private String name;
    private String phone;
    private String fax;
    private String email;
    @Column(length = 4096)
    private String branchDescription;
    private int kolej;
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @JoinTable(name = "managmentBranch", joinColumns = @JoinColumn(name = "branchId"), inverseJoinColumns = @JoinColumn(name = "managmentId"))
//    private Set<Managment> managments;
}
