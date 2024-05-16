package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_hospital_wkrm")
public class Views {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalConfigId;
    private String hospitalConfigDescription;
    private int numberOfBeds;
    private Integer numberOfBedsLocked;
    private Long branchId;
    private Long hospitalId;
    private String description;
    private String email;
    private String fax;
    private String phone;
    private Long hospitalReportId;
    private Long reportId;
    private String szpital;
    private String oddzial;
    private int statea;
    private String statea_1;
    private int stateb;
    private String stateb_1;
    private int statec;
    private String statec_1;
    private int doctora;
    private LocalDateTime update_date;
    private String powiat;
//    private String managmentDescription;
//    private String managmentEmail;
//    private String managmentMobilePhone;
//    private String managmentPerson;
//    private String managmentPhone;
}
