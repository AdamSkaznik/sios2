package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "v_hospital_view")
public class UserView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospital_report_id;
    private Long report_id;
    private String szpital;
    private String oddzial;
    private int statea;
    private String statea_1;
    private int stateb;
    private String stateb_1;
    private int statec;
    private String statec_1;
    private String powiat;
    private LocalDateTime update_date;
}
