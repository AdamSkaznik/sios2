package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//kategoria szpitala
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_category")
public class HospitalCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hospitalCategoryId;
    private String name;
}
