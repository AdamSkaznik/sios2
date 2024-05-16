package local.wpr.start.sios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//szpital zagrożenia odpowiedzi
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_hospital_report_threads_answers")
public class HospitalReportThreadsAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "hospitalReportId", nullable = true)
    private HospitalReport hospitalReport;
    @ManyToOne
    @JoinColumn(name = "hospitalThreadsQuestionId", nullable = true)
    private HospitalReportThreadsQuestion question;
}
