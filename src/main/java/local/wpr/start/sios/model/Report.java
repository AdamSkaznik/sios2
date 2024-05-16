package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_reports")
public class Report {
    @Id
    @SequenceGenerator(name = "tab_reports_seq", sequenceName = "tab_report_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tab_reports_seq")
    private Long id;
    private Date date;
}
