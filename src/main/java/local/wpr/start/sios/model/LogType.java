package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_log_type")
public class LogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logTypeId;
    private String logTypeName;
}
