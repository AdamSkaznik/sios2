package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_wkrm_question")
public class WkrmQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nazwa;
    private int ordered;
    private boolean isVisible;

}
