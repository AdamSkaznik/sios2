package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.repository.RoleRepository;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class WkrmController {
    private static final Logger LOG = LoggerFactory.getLogger(WkrmController.class);
    private static final String LOG_TITLE = "WKRM - LOG";
    @Autowired
    ViewServiceImpl viewService;
    @Autowired
    ReportServiceImpl reportService;
    @Autowired
    MessagesServiceImpl messagesServiceImpl;
    @Autowired
    MessagesFileServiceImpl messagesFileServiceImpl;
    @Autowired
    UserService userService;
    @Autowired
    HospitalServiceImpl hospitalServiceImpl;
    @Autowired
    HospitalReportServiceImpl hospitalReportServiceImpl;
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
    @Autowired
    HospitalBranchClosedServiceImpl hospitalBranchClosedServiceImpl;
    @Autowired
    HospitalFailuresServiceImpl hospitalFailuresServiceImpl;
    @Autowired
    HospitalProceduresServiceImpl hospitalProceduresServiceImpl;
    @Autowired
    LogServiceImpl logServiceImpl;
    @Autowired
    RoleRepository roleRepository;
//    @Autowired
//    ViewController viewController;
//
//    public WkrmController(ViewController viewController) {
//        this.viewController = viewController;
//    }

    @GetMapping("/wkrm/index")
    public String goIndex(Principal principal, Model model)
    {
        String uName = principal.getName();
        User user = userService.findUserByUserName(uName);
//        User user = userService.findUserByUserName(principal.getName());
        Log log = new Log();
        log.setLogType(LOG_TITLE);
        log.setUser(user);
        log.setLogDesc("Logowanie użytkownika: " + user.getName());
        LocalDateTime ldt = LocalDateTime.now();
        log.setCreatedDate(ldt);
        logServiceImpl.saveLog(log);
        model.addAttribute("messagesList", messagesServiceImpl.getActiveMessages());
        model.addAttribute("user", user);
        return "/wkrm/index";
    }

    @GetMapping("wkrm/detailsMessage/{id}")
    public String goWkrmDetailsMessage(Model model, @PathVariable Long id){
        Messages messages = messagesServiceImpl.getMessagesById(id);
        model.addAttribute("messages", messages);
        return "/wkrm/detailsMessage";
    }
    @GetMapping("/wkrm/addMessages")
    public String goWkrmAddMessages(Model model) {
        Messages messages = new Messages();
        model.addAttribute("messages", messages);
        return "/wkrm/addMessages";
    }

    @PostMapping("/saveWkrmMessages")
    public String saveWkrmMessages(@ModelAttribute("messages") Messages messages, Principal principal, @RequestParam(value = "files", required = false) MultipartFile[] files, Model model){
        try {
            User user = userService.findUserByUserName(principal.getName());
//            Messages mess = new Messages();
            messages.setUser(user);
            messages.setHospital(user.getHospital());
            LocalDateTime dt = LocalDateTime.now();
            messages.setAddDate(dt);
            messages.setMessagesActive(true);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(messages.getDStart());
            Date d2 = sdf.parse(messages.getDEnd());
            messages.setStartDate(d1);
            messages.setEndDate(d2);
            System.out.println("Zapisuję message ......");
            Messages mess = messagesServiceImpl.saveMessages(messages);
            System.out.println("Messages : " + mess);
            System.out.println("Files: " + files);
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    if (messagesFileServiceImpl.fileExists(file.getOriginalFilename())) {
                        System.out.println("Odpowiedź: " + messagesFileServiceImpl.fileExists(file.getOriginalFilename()));
                        model.addAttribute("errorMessage", "Plik o nazwie " + file.getOriginalFilename() + " już istnieje. Zmień nazwę pliku");
                        model.addAttribute("error", "Plik o takiej nazwie już istnieje w bazie!");
                        model.addAttribute("messages", mess);
                        System.out.println("Plik istnieje....");
//                        System.out.println(e);
                        return "/wkrm/addMessages";
                    }
                    messagesFileServiceImpl.saveMessagesFiles(file, mess);
                }
//                return "redirect:/hospital/index";
            }
            return "redirect:/wkrm/index";
        }catch (IOException e){
            return "/wkrm/addMessages";
        }catch (Exception e){
            return "error";
        }

    }
    @GetMapping("/wkrm/editMessage/{id}")
    public String goWkrmEditMessage(Model model, @PathVariable Long id){
        model.addAttribute("messages", messagesServiceImpl.getMessagesById(id));
        return "/wkrm/editMessage";
    }

    @GetMapping("/wkrm/hospitalExclusion")
    public String goWkrmHospitalExclusion(Model model){
        model.addAttribute("listHospitalBranchClosed", hospitalBranchClosedServiceImpl.getAll());
        return "/wkrm/hospitalExclusion";
    }

    @GetMapping("/wkrm/hospitalMailfunctions")
    public String goWkrmHospitalMailfunctions(Model model){
        model.addAttribute("listHospitalFailures", hospitalFailuresServiceImpl.getAllHospitalFailures());
        return "/wkrm/hospitalMailfunctions";
    }

//    @GetMapping("/wkrm/detailsHospitalFailures/{id}")
//    public String goWkrmDetailsHospitalFailures(Model model, @PathVariable Long id){
//
//    }

    @GetMapping("/wkrm/hospitalProcedures")
    public String goWkrmHospitalProcedures(Model model){
        model.addAttribute("procedures", hospitalProceduresServiceImpl.getAllProcedures());
        return "/wkrm/hospitalProcedures";
    }

    @GetMapping("/wkrm/detailsProcedures/{id}")
    public String goWkrmDetailsProcedures(Model model, @PathVariable Long id){
        HospitalProcedures hospitalProcedures = hospitalProceduresServiceImpl.getHospitalProceduresById(id);
        model.addAttribute("hospitalProcedures", hospitalProcedures);
        return "/wkrm/detailsProcedures";
    }

    @GetMapping("/wkrm/allMessages")
    public String goWkrmAllMessages(Model model){
        model.addAttribute("messagesList", messagesServiceImpl.getAllMessages());
        return "/wkrm/allMessages";
    }
    @GetMapping("/wkrm/reportHospitalTable")
    public String goReportHospitalTable(){
        return "/wkrm/reportHospitalTable";
    }

    @GetMapping("/wkrm/addReport/{id}")
    public String goWkrmAddHospitalReport(Model model, Principal principal, @PathVariable Long id){
        Hospital hospital = hospitalServiceImpl.getHospitalById(id);
        System.out.println("Hospital: " + hospital);
        LocalDate date = LocalDate.now();
        System.out.println("Data: " + date);
        Report report = reportService.getReportByDate(date);
        System.out.println("Report: " + report);
        if(report != null){
            List<HospitalReport> hospitalReports = hospitalReportServiceImpl.getByHospitalIdAndReportId(report.getId(), hospital.getHospitalId());
            System.out.println("Lista raportów szpitala : " + hospitalReports);
            model.addAttribute("hospitalReports", hospitalReports);
            model.addAttribute("hospitalName", hospital.getName());
        } else {
            System.out.println("Report wynosiiii nullll");
            LOG.error("Nie znaleziono raportów dla daty: " + date);
        }
        return "/wkrm/addReport";
    }

    @GetMapping("/wkrm/reportHospitalArchivedTable")
    public String goReportHospitalArchivedTable(){
        return "/wkrm/reportHospitalArchivedTable";
    }

    @GetMapping("/wkrm/reportDetails/{id}")
    public String goReportDetails(Model model, @PathVariable Long id) throws Exception {
        System.out.println("Id wynosi: " + id);
        Report report = null;
        report = reportService.getOneReportById(id);
        model.addAttribute("report", report);
//        viewController.getByReportId(id);
//        viewController.getByReportId(id);
        return "/wkrm/reportDetails";
    }

    @GetMapping("/wkrm/details/{id}")
    public String goDetails(Model model, @PathVariable Long id) throws Exception{
        Views views = viewService.getOneById(id);
        model.addAttribute("views", views);
        return "/wkrm/details";
    }
    @GetMapping("/wkrm/contact/{id}")
    public String goContactById(@PathVariable Long id, Model model){
        HospitalConfig hospitalConfig = null;
        hospitalConfig = hospitalConfigServiceimpl.getHospitalConfigById(id);
        System.out.println("Hospital config: " + hospitalConfig.getHospitalConfigId()+"; " + hospitalConfig.getHospitalConfigDescription() + "; " + hospitalConfig.getBranch().getName() +"; " + hospitalConfig.getManagment());
        model.addAttribute("hospitalConfig", hospitalConfig);
        return "/wkrm/contact";
    }

    @GetMapping("/wkrm/admin/users")
    public String goAdminUsers(){
        return "/wkrm/admin/users";
    }

    @GetMapping("/wkrm/admin/addUser")
    public String goAdminNewUser(Model model){
        User user = new User();
        List<Role> roles = roleRepository.findRoleToWkrm();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roles);
        return "/wkrm/admin/addUser";
    }

    @GetMapping("/wkrm/hospitalChoice")
    public String goHospitalChoice(){
        return "/wkrm/hospitalChoice";
    }


}
