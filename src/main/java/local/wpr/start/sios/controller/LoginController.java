package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.model.HospitalReport;
import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.model.UserView;
import local.wpr.start.sios.service.HospitalReportService;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.service.impl.UserViewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserViewServiceImpl userViewService;
    @Autowired
    ReportServiceImpl reportService;
    @Autowired
    HospitalReportService hospitalReportService;
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;


    @GetMapping(value = {"/", "/index"})
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
//        Report report = reportService.getByActualDate();
//        if(report == null){
//            report = new Report();
//            report.setDate(new Date());
//            System.out.println("Tworzę nowy raport ....");
//            reportService.saveReport(report);
//            Report report1 = reportService.getByActualDate();
//            Long reportId = report1.getId();
//            System.out.println("$$$$$$$$$$$ nowy raport ma id: " + reportId);
//            List<HospitalReport> hospitalReportList = hospitalReportService.getAllByReportId(reportId);
//            int count = hospitalReportList.size();
//            System.out.println("Size hospitalReportList wynosi: " + count);
//            if(count == 0){
//                List<HospitalConfig> hospitalConfigs = hospitalConfigServiceimpl.getAllHospitalConfig();
//                int a = hospitalConfigs.size();
//                for (int i = 0; i < a; i++){
////                    Long config = hospitalConfigs.get(i).getHospitalConfigId();
////                    Long hospital = hospitalConfigs.get(i).getHospital().getHospitalId();
//                    HospitalReport hospitalReport = new HospitalReport();
//                    hospitalReport.setHospitalConfig(hospitalConfigs.get(i));
//                    hospitalReport.setHospital(hospitalConfigs.get(i).getHospital());
//                    hospitalReport.setReport(report1);
//                    hospitalReportService.saveHospitalReport(hospitalReport);
//                }
//            }
//        } else {
//            System.out.println("Tworzenie nowego raportu nie jest potrzebne ...");
//            System.out.println("************************************************");
//            System.out.println("Istnieje raport o nr: " + report.getId() + " dla daty: " + report.getDate());
////            Report report1 = reportService.getByActualDate();
////            System.out.println("Id raportu wynosi: " + report1.getId() + "dla dnia: " + report1.getDate());
////            List<HospitalReport> hospitalReports = hospitalReportService.getAllByReportId(report1.getId());
////            if (hospitalReports == null){
////                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
////                System.out.println("HAHAHAHAHAHA!!!! Nie ma ......");
////                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
////        }
//        }
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/index";
    }

    @GetMapping("/restrict/index")
    public String restrict(){

        return "/restrict/index";
    }
}
