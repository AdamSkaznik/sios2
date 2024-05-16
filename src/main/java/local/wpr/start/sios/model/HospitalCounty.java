package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//powiat
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_county")
public class HospitalCounty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hospitalCountyId;
    private String name;


}
