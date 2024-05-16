package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_hospital_choice")
public class HospitalChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalId;
    private String powiat;
    private String szpital;
}
