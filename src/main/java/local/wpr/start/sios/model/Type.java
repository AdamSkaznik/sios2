package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;
    private String typeName;
    private String typeDescription;
}
