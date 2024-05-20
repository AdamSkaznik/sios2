package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_hospital_select")
public class SelectView {
    @Id
//    @Transient
    private Long hospitalConfigId;
//    @Transient
    private String szpital;
//    @Transient
    private String oddzial;
//    @Transient
    private String powiat;
    private Long hospitalId;
}
