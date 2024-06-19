package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.repository.MessagesFilesRepository;
import local.wpr.start.sios.repository.RoleRepository;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @Autowired
    MessagesServiceImpl messagesServiceImpl;
    @Autowired
    MessagesFileServiceImpl messagesFileServiceImpl;
    @Autowired
    AnnouncementServiceImpl announcementServiceImpl;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MessagesFilesRepository messagesFilesRepository;
    @Autowired
    HospitalBranchClosedServiceImpl hospitalBranchClosedServiceImpl;

    private static final Logger LOG = LoggerFactory.getLogger(HospitalController.class);

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @GetMapping("/hospital/index")
    public String goHospitalIndex(HttpSession httpSession, Principal principal, Model model){
        String uName = principal.getName();
        User user = userService.findUserByUserName(uName);
        System.out.println("User Id: " + user.getId());
        Long uId = Long.valueOf(user.getId());
        Integer privateMess = privateMessageService.countPrivateMessages(uId);
        Announcement announcement = announcementServiceImpl.getLast();
        if(announcement != null){
            model.addAttribute("announcement", announcement);
            System.out.println("Jest ogłoszenie");
            System.out.println("Ogłoszenie : " + announcement);
        }
        httpSession.setAttribute("privateMess", privateMess);
//        Messages messages = messagesServiceImpl.getAllMessages();
//        model.addAttribute("messagesList", messagesServiceImpl.getAllMessages());
        model.addAttribute("messagesList", messagesServiceImpl.getActiveMessages());
        model.addAttribute("user", user);
        return "/hospital/index";
    }

    @GetMapping("/hospital/account")
    public String goHospitalAccount(Principal principal, Model model){
        User user = userService.findUserByUserName(principal.getName());
        model.addAttribute("user", user);
        System.out.println("User:" + user);
        return "/hospital/account";
    }

    @GetMapping("/hospital/users")
    public String goHospitalUsers(){
        return "/hospital/hospitalUsers";
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
@GetMapping("/hospital/ownHospitalReports")
public String goOwnHospitalReports(){
        return "/hospital/ownHospitalReports";
}

    @GetMapping("/hospital/ownArchiveHospitalReports")
    public String goOwnHospitalArchiveHospitalReports(){
        return "/hospital/ownArchiveHospitalReports";
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
    public String goAddMessages(Model model) {
        Messages messages = new Messages();
        model.addAttribute("messages", messages);
        return "/hospital/addMessages";
    }
    @GetMapping("/hospital/hospitalExclusion")
    public String goHospitalExclusion(Model model){
       model.addAttribute("listHospitalBranchClosed", hospitalBranchClosedServiceImpl.getAll());
        return "/hospital/hospitalExclusion";
}
    @GetMapping("/hospital/hospitalMailfunctions")
    public String goHospitalMailfunctions(){
        return "/hospital/hospitalMailfunctions";
    }
    @GetMapping("/hospital/addExclusion")
    public String goAddExclusion(Model model){
        HospitalBranchClosed hospitalBranchClosed = new HospitalBranchClosed();
        model.addAttribute("hospitalBranchClosed", hospitalBranchClosed);
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

//    @GetMapping("/hospital/hospitalConfig")
//    public String goHospitalConfig(){
//        return "/hospital/hospitalConfig";
//    }

    @GetMapping("/hospital/address_add")
    public String goHospitalAddressAdd(){
        return "/hospital/address_add";
    }
    @GetMapping("/hospital/hospitalConfig_add")
    public String goHospitalConfigAdd(HospitalConfig hospitalConfig){
        return "/hospital/hospitalConfig_add";
    }

    @GetMapping("/hospital/hospitalConfig_edit/{id}")
    public String goHospitalConfigEdit(Model model, @PathVariable Long id) throws Exception{
        System.out.println("ID config wynosi: " + id);
        HospitalConfig hospitalConfig = hospitalConfigServiceimpl.getHospitalConfigById(id);
        model.addAttribute("hospitalConfig", hospitalConfig);
        return "/hospital/hospitalConfig_edit";
    }

    @GetMapping("/hospital/hospitalConfig_details/{id}")
    public String goHospitalConfigDetails(Model model, @PathVariable Long id) throws Exception{
//        System.out.println("");
        HospitalConfig hospitalConfig = hospitalConfigServiceimpl.getHospitalConfigById(id);
        model.addAttribute("hospitalConfig", hospitalConfig);
        return "/hospital/hospitalConfig_details";
    }
    @GetMapping("/hospital/hospitalProcedures")
    public String goHospitalProcedures(Model model, Principal principal){
        User user = userService.findUserByUserName(principal.getName());
        Long hospitalId = user.getHospital().getHospitalId();
        model.addAttribute("procedures", hospitalProceduresServiceImpl.getAllHospitalProcedures());
        model.addAttribute("hospitalId", hospitalId);
        return "/hospital/hospitalProcedures";
    }
        @GetMapping("/hospital/allMessages")
    public String goHospitalAllMessages(Model model, Principal principal){
        model.addAttribute("messagesList", messagesServiceImpl.getAllMessages());
        model.addAttribute("user", userService.findUserByUserName(principal.getName()));
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

    @GetMapping("/hospital/ownHospitalReportDetails/{id}")
    public String goOwnHospitalDetails(Model model, @PathVariable Long id) throws Exception{
        System.out.println("Id wynosi: " + id);
        Report report = null;
        report = reportServiceImpl.getOneReportById(id);
        model.addAttribute("report", report);
        return "/hospital/ownHospitalReportDetails";
    }

    @PostMapping("/saveMessages")
    public String saveMessages(@ModelAttribute("messages") Messages messages, Principal principal, @RequestParam(value = "files", required = false) MultipartFile[] files, Model model){
        try {
            User user = userService.findUserByUserName(principal.getName());
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
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    if (messagesFileServiceImpl.fileExists(file.getOriginalFilename())) {
                        System.out.println("Odpowiedź: " + messagesFileServiceImpl.fileExists(file.getOriginalFilename()));
                        model.addAttribute("errorMessage", "Plik o nazwie " + file.getOriginalFilename() + " już istnieje. Zmień nazwę pliku");
                        model.addAttribute("error", "Plik o takiej nazwie już istnieje w bazie!");
                        model.addAttribute("messages", mess);
                        System.out.println("Plik istnieje....");
//                        System.out.println(e);
                        return "hospital/addMessages";
                    }
                    messagesFileServiceImpl.saveMessagesFiles(file, mess);
                }
//                return "redirect:/hospital/index";
            }
            return "redirect:/hospital/index";
        }catch (IOException e){
            return "/hospital/addMessages";
        }catch (Exception e){
            return "error";
        }

    }

    @GetMapping("hospital/detailsMessage/{id}")
    public String goHospitalDetailsMessage(Model model, @PathVariable Long id){
        Messages messages = messagesServiceImpl.getMessagesById(id);
        model.addAttribute("messages", messages);
        return "/hospital/detailsMessage";
    }

    @GetMapping("hospital/editMessage/{id}")
    public String goHospitalEditMessage(Model model, @PathVariable Long id){
        model.addAttribute("messages", messagesServiceImpl.getMessagesById(id));
        return "/hospital/editMessage";
    }
    @GetMapping("hospital/editMessage1/{id}")
    public String goHospitalEditMessage1(Model model, @PathVariable Long id){
        model.addAttribute("messages", messagesServiceImpl.getMessagesById(id));
        return "/hospital/editMessage1";
    }

    @GetMapping("/hospital/detailsProcedures/{id}")
    public String goHospitalDetailsProcedure(Model model, @PathVariable Long id){
        model.addAttribute("hospitalProcedures", hospitalProceduresServiceImpl.getHospitalProceduresById(id));
        return "/hospital/detailsProcedures";
    }
    @PostMapping("/saveHospitalProcedures")
    public String saveNewHospitalProcedures(@ModelAttribute("hospitalProcedures") HospitalProcedures hospitalProcedures, Principal principal, @RequestParam(value = "files", required = false)MultipartFile[] files, Model model){
        try {
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
            for (MultipartFile file : files){
                if(hospitalProceduresFileServiceImpl.fileExists(file.getOriginalFilename())){
                    System.out.println("Błąd - istniejący plik!");
                    model.addAttribute("errorMessage", "Plik o takiej nazwie już istnieje! Zmień nazwę pliku!");
                    System.out.println();
                return "/hospital/addProcedure";
                }
                hospitalProceduresFileServiceImpl.saveHospitalProceduresFile(file, procedures);
            }
            return "redirect:/";
        } catch (IOException e) {
            LOG.error("Błąd podczas zapisu lub wgrywania pliku", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "/hospital/addProcedure";
        } catch (Exception e){
            LOG.error("Błąd podczas zapisu procedury", e);
            return "error";
        }
        }

        @GetMapping("/hospital/admin/passChange/{id}")
    public String goHospitaChangePass(Model model, @PathVariable Integer id){
        User user = userService.findById(id);
            System.out.println("User: " + user);
        model.addAttribute("user", user);
        return "/hospital/admin/passChange";
        }

        @GetMapping("/hospital/admin/addUser")
    public String goHospitalAddUser(Model model){
        User user = new User();
        List<Role> roles = roleRepository.findRoleToHospital();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roles);
        return "/hospital/admin/addUser";
        }

        @PostMapping("/hospital/admin/saveNewUser")
    public String goSaveNewUser(@ModelAttribute("user") User user, Principal principal) throws Exception{
       String adminName = principal.getName();
       User user1 = userService.findUserByUserName(adminName);
       Hospital hospital = user1.getHospital();
       String tempLogin = user.getUserName();
       if(tempLogin !=null && !"".equals(tempLogin)){
           try {
               user.setHospital(hospital);
               user.setPassword(passwordEncoder().encode(user.getPassword()));
               user.setRoles(user.getRoles());
               Set<Role> roles = user.getRoles();
               System.out.println("Role:" + user.getRoles());
               Date dt = new Date();
//               user.setRoles(user.getRoles().);
               user.setPasswordChangedTime(dt);
               user.setName(user.getFirstName()+" "+user.getLastName());
               userService.saveUser(user);
               return "redirect:/hospital/users";
           }catch (Exception e){
               System.out.println("Błąd: " + e.getMessage());
           }

       }
            return "/hospital/users";
//       User user1 = userService.findUserByUserName(adminName);
//        try {
//            user.setHospital(user1.getHospital());
//           userService.saveUser(user);
//        } catch (Exception e){
//            System.out.println("Błąd: " + e.getMessage());
//        }
//        return "redirect:/hospital/users/";
        }

       @GetMapping("/hospital/deleteMessageFile/{id}")
    public String goDeleteMessageFile(@PathVariable Long id, Model model){
           System.out.println("fileId:" + id);
        MessagesFiles messagesFiles = messagesFilesRepository.getReferenceById(id);
        try {
            messagesFileServiceImpl.deleteFile(messagesFiles.getFileName());
            messagesFilesRepository.delete(messagesFiles);

        } catch (Exception e){
            LOG.error("Błąd podczas usuwania pliku", e);
            model.addAttribute("errorMessage", "Błąd podczas usuwania pliku");
        }
        return "redirect:/hospital/editMessage/" + messagesFiles.getMessages().getMessagesId();
        }
        }
