package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_wkrm_status")
public class WkrmStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nazwa;
}
