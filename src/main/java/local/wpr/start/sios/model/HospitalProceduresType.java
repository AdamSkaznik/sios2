package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_procedures_type")
public class HospitalProceduresType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalProceduresTypeId;
    private String hospitalProceduresTypeDesc;
    private boolean active;
}
