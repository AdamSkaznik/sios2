package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    UserService userService;
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
    @Autowired
    HospitalServiceImpl hospitalServiceImpl;
    @Autowired
    AddressServiceImpl addressServiceImpl;
    @Autowired
    BranchServiceImpl branchServiceImpl;
    @Autowired
    PrivateMessageServiceImpl privateMessageService;
    @Autowired
    ReportServiceImpl reportServiceImpl;
    @Autowired
    HospitalReportServiceImpl hospitalReportServiceImpl;
    @Autowired
    HospitalProceduresServiceImpl hospitalProceduresServiceImpl;
    @Autowired
    HospitalProceduresTypeServiceImpl hospitalProceduresTypeServiceImpl;
    @Autowired
    HospitalProceduresFileServiceImpl hospitalProceduresFileServiceImpl;

    private static final Logger LOG = LoggerFactory.getLogger(HospitalController.class);

    @GetMapping("/hospital/index")
    public String goHospitalIndex(HttpSession httpSession, Principal principal){
        String uName = principal.getName();
        User user = userService.findUserByUserName(uName);
        System.out.println("User Id: " + user.getId());
        Long uId = Long.valueOf(user.getId());
        Integer privateMess = privateMessageService.countPrivateMessages(uId);
        httpSession.setAttribute("privateMess", privateMess);
        return "/hospital/index";
    }

    @GetMapping("/hospital/privateMessage")
    public String goNewMyMessage(Principal principal, Model model){
        User user = userService.findUserByUserName(principal.getName());
        PrivateMessage privateMessage = privateMessageService.getMy(Long.valueOf(user.getId()));
        if(privateMessage != null){
            model.addAttribute("privateMessage", privateMessage);
            return "/hospital/newPrivateMessage";
        } else {
            return "redirect:/hospital/index";
        }
//        model.addAttribute("privateMessage", privateMessage);
    }

    @GetMapping("/hospital/hospitalReports")
    public String goHospitalReport(){
        return "/hospital/hospitalReports";
    }

    @GetMapping("/hospital/hospitalReportByDay")
    public String goHospitalReportByDay(){
        return "/hospital/hospitalReportByDay";
    }

    @GetMapping("/hospital/addMessages")
    public String goAddMessages(){
        return "/hospital/addMessages";
    }

    @GetMapping("/hospital/addExclusion")
    public String goAddExclusion(){
        return "/hospital/addExclusion";
    }

    @GetMapping("/hospital/addMailfunctions")
    public String goAddMailfunction(){
        return "/hospital/addMailfunctions";
    }
    @GetMapping("/hospital/addProcedure")
    public String goAddProcedure(Model model){
        HospitalProcedures hospitalProcedures = new HospitalProcedures();
        model.addAttribute("hospitalProcedures", hospitalProcedures);
        return "/hospital/addProcedure";
    }
    @GetMapping("/hospital/testTable")
    public String goTestTable(){
        return "/hospital/testTable";
    }

    @GetMapping("/hospital/hospitalConfig")
    public String goHospitalConfig(Principal principal){
        String name = principal.getName();
        User user = null;
        user = userService.findUserByUserName(name);
        HospitalConfig hospitalConfig = null;
//        hospitalConfig = hospitalConfigServiceimpl.
        return "/hospital/hospitalConfig";
    }
    @GetMapping("/hospital/addReport")
    public String goAddReport(Model model, Principal principal){
        String name = principal.getName();
        User user = null;
        user = userService.findUserByUserName(name);
        Hospital hospital = hospitalServiceImpl.getHospitalById(user.getHospital().getHospitalId());
        LocalDate date = LocalDate.now();
        System.out.println("Data: " + date);
        Report report = reportServiceImpl.getReportByDate(date);
        System.out.println("Report: " + report);
        if (report != null){
            List<HospitalReport> hospitalReports = hospitalReportServiceImpl.getByHospitalIdAndReportId(report.getId(), user.getHospital().getHospitalId());
            System.out.println("Lista raportów szpitala : " + hospitalReports);
            model.addAttribute("hospitalReports", hospitalReports);
            model.addAttribute("hospitalName", hospital.getName());
        } else {
            System.out.println("Report wynosiiii nullll");
            LOG.error("Nie znaleziono raportów dla daty: " + date);
        }
//        List<HospitalReport> hospitalReports = hospitalReportServiceImpl.
//        List<HospitalConfig> hospitalConfigs = hospitalConfigServiceimpl.getAllByHospitalId(user.getHospital().getHospitalId());
//        model.addAttribute("hospitalConfigs", hospitalConfigs);
//        List<Branch> branches = branchServiceImpl.getAllBranch();
//        model.addAttribute("branches", branches);
        return "/hospital/addReport";
    }
    @GetMapping("/hospital/address")
    public String goHospitalAddress(Model model, Principal principal){
        String userName = principal.getName();
        System.out.println("Username: " + userName);
        User user = userService.findUserByUserName(userName);
        System.out.println("User: " + user);
        Long hospitalId = user.getHospital().getHospitalId();
        System.out.println("HospitalId: " + hospitalId);
        Hospital hospital = null;
        hospital = hospitalServiceImpl.getHospitalById(hospitalId);
        System.out.println("Hospital: " + hospital);
        Address address = addressServiceImpl.getAdresById(hospital.getAddress().getAddressId());
        System.out.println("Address: " + address);
        model.addAttribute("address", address);
        return "/hospital/address";
    }

    @GetMapping("/hospital/address_add")
    public String goHospitalAddressAdd(){
        return "/hospital/address_add";
    }
    @GetMapping("/hospital/hospitalConfig_add")
    public String goHospitalConfigAdd(HospitalConfig hospitalConfig){
        return "/hospital/hospitalConfig_add";
    }

    @GetMapping("/hospital/hospitalProcedures")
//    public String goHospitalProcedures(){
    public String goHospitalProcedures(Model model){
        model.addAttribute("procedures", hospitalProceduresServiceImpl.getAllHospitalProcedures());
        return "/hospital/hospitalProcedures";
    }

//    @GetMapping("/downloadHospitalProcedures")
//    public void downloadHospitalFile(HttpServletResponse response){
//        Resource resource = new ClassPathResource("/uploadProcedures");
//        response.setContentType("text/plain");
//        response.setHeader("Content-Disposition", "attachment; filename=" + resource.getFilename());
////        InputStream inputStream = resource.getInputStream();
//        OutputStream outputStream = response.getOutputStream();

//    }

    @GetMapping("/hospital/allMessages")
    public String goHospitalAllMessages(){
        return "/hospital/allMessages";
    }

    @GetMapping("/hospital/hospitalReportDetails/{id}")
    public String goHospitalReportDetails(Model model, @PathVariable Long id) throws Exception {
        System.out.println("Id wynosi: " + id);
        Report report = null;
        report = reportServiceImpl.getOneReportById(id);
        model.addAttribute("report", report);
//        viewController.getByReportId(id);
//        viewController.getByReportId(id);
        return "/hospital/hospitalReportDetails";
    }

    @PostMapping("/saveHospitalProcedures")
    public String saveNewHospitalProcedures(@ModelAttribute("hospitalProcedures") HospitalProcedures hospitalProcedures, Principal principal, @RequestParam("files")MultipartFile[] files){

        User user = userService.findUserByUserName(principal.getName());
        hospitalProcedures.setUser(user);
        Hospital hospital = hospitalServiceImpl.getHospitalById(user.getHospital().getHospitalId());
        hospitalProcedures.setHospital(hospital);
        Long idHospProc = hospitalProcedures.getHospitalProceduresType().getHospitalProceduresTypeId();
        HospitalProceduresType hospitalProceduresType = hospitalProceduresTypeServiceImpl.getById(idHospProc);
        hospitalProcedures.setHospitalProceduresType(hospitalProceduresType);
        hospitalProcedures.setProcedureActive(true);
        LocalDateTime ldt = LocalDateTime.now();
        hospitalProcedures.setLocalDateTime(ldt);
        hospitalProcedures.setModifiedDateTime(ldt);
        HospitalProcedures procedures = hospitalProceduresServiceImpl.saveHospitalProcedures(hospitalProcedures);
        try {
            for (MultipartFile file: files){
                hospitalProceduresFileServiceImpl.saveHospitalProceduresFile(file, procedures);
            }

            } catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/hospital/hospitalProcedures";
    }
}
