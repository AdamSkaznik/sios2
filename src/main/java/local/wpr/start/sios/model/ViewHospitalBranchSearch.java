package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "v_hospital_branch_search")
public class ViewHospitalBranchSearch {
    @Id
    private Long hospitalConfigId;
    private Long hospitalId;
    private String name;
}
