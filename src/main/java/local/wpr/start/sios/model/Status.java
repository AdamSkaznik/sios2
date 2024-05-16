package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusId;
    private String statusName;
    private String statusDescription;

}
