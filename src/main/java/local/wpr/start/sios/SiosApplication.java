package local.wpr.start.sios;

import local.wpr.start.sios.model.Hospital;
import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.model.HospitalReport;
import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.repository.HospitalReportRespository;
import local.wpr.start.sios.repository.ReportRepository;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import local.wpr.start.sios.service.impl.HospitalReportServiceImpl;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.utils.FilesStorageService;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@Async
public class SiosApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(SiosApplication.class);
	@Autowired
	ReportRepository reportRepository;
	@Autowired
	ReportServiceImpl reportServiceImpl;
	@Autowired
	HospitalConfigServiceimpl hospitalConfigServiceimpl;
	@Autowired
	HospitalReportServiceImpl hospitalReportServiceimpl;
	@Autowired
	HospitalReportRespository hospitalReportRespository;

	public SiosApplication(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SiosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date da = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sf.format(da);
		LOG.info("Uruchomienie aplikacji " + now);
		storageService.init();
	}
@Scheduled(cron = "0 15 20 ? * *")
@Async
	public void newReportJob(){
	Date da = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String now = sf.format(da);
	LOG.info("Uruchomienie zadania w CRON (nowy raport na nowy dzień) " + now);
	Report report = reportServiceImpl.getByNextDay();
	System.out.println("Report: " + report);
	if(report == null) {
		Date dt = Date.from(DateUtils.addDays(new Date(), + 1).toInstant());
		System.out.println("Data: " + dt);
		try {
			Report rp = new Report();
			rp.setDate(Date.from(dt.toInstant()));
			reportServiceImpl.saveReport(rp);
			System.out.println(".....ZAPISANO rp...");
		} catch (Exception e) {
			LOG.error("Błąd podczas zapisu nowego raportu !!! " + e.getMessage());
			System.out.println("Nie udany zapis głównego raportu: " + e.getMessage());
		}
		Report rp = null;
		rp = reportServiceImpl.getByNextDay();
		System.out.println("Ostatni raport wynosi: " + rp.getId());
		List<HospitalConfig> conf = hospitalConfigServiceimpl.getAllActive();
		System.out.println("Znaleziono: " + conf.size() + " rekordów");
		int configs = conf.size();
		if(configs != 0) {
			try{
				for(int i=0; i<configs; i++){
					System.out.println("Rekord nr: " + i + " z: " + configs);
					HospitalConfig hc = conf.get(i);
					System.out.println("HC wynosi: " + hc);
					Long a1 = hc.getHospitalConfigId();
					Hospital a2 = hc.getHospital();
					System.out.println("A2 wynosi: " + a2);
					HospitalReport hr = new HospitalReport();
					hr.setHospitalConfig(hc);
					hr.setHospital(a2);
					hr.setReport(rp);
					hospitalReportServiceimpl.saveHospitalReport(hr);
					hc = null;
				}
				Date da1 = new Date();
				SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String now1 = sf.format(da1);
				LOG.info("Uruchomienie aplikacji " + now1);
				System.out.println("Wykonano wszystkie zadania ....");
				LOG.info("Wykonao wszystkie zadania ... Czas realizacji : ");
			} catch (Exception e){
			LOG.error("Nie udało się utworzyć raportów dla szpitali! " + e.getMessage());
				System.out.println("Nie udało się utworzyć raportów dla szpitali! " + e.getMessage());
			}

		} else {
			System.out.println("Hospital reports jest równe 0. Nie potrzeba tworzyć nowych raportów!");
		}
	} else {
		System.out.println("Raport dla daty został już wygenerowany i nie potrzeba generować nowego!");
	}

	}

}
