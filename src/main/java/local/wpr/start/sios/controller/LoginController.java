package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.service.HospitalReportService;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import local.wpr.start.sios.service.impl.LogServiceImpl;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.service.impl.UserViewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final long PASSWORD_EXPIRATION_TIME = 30L * 24L * 60L * 1000L;
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private static final String LOG_TITLE = "Logowanie - LOG";
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
    @Autowired
    LogServiceImpl logServiceImpl;


    @GetMapping(value = {"/", "/index"})
    public ModelAndView home(Principal principal){
        ModelAndView mav = new ModelAndView();
//        User user = userService.findUserByUserName(principal.getName());
//        Log log = new Log();
//        log.setLogType(LOG_TITLE);
//        log.setUser(user);
//        log.setLogDesc("Logowanie użytkownika " + user.getName());
//        LocalDateTime ldt = LocalDateTime.now();
//        log.setCreatedDate(ldt);
//        logServiceImpl.saveLog(log);
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Principal principal){
        User user = userService.findUserByUserName(principal.getName());
        Log log = new Log();
        log.setLogType(LOG_TITLE);
        log.setUser(user);
        log.setLogDesc("Wylogowanie użytkownika " + user.getName());
        LocalDateTime ldt = LocalDateTime.now();
        log.setCreatedDate(ldt);
        logServiceImpl.saveLog(log);
        return "redirect:/index";
    }

    @GetMapping("/restrict/index")
    public String restrict(Model model, Principal principal){

        long currentTime = System.currentTimeMillis();
        User user = userService.findUserByUserName(principal.getName());
        long lastChangedTime = user.getPasswordChangedTime().getTime();
        String ile = String.valueOf(currentTime > lastChangedTime + PASSWORD_EXPIRATION_TIME);
        LocalDate date = LocalDate.ofEpochDay(PASSWORD_EXPIRATION_TIME);
        System.out.println("Hasło wygasło ?: " + user.isPasswordExpired());
        System.out.println("****************************");
        System.out.println("Aktualny czas : " + currentTime);
        System.out.println("****************************");
        System.out.println("ZMiana hasła była : " + lastChangedTime);
        System.out.println("*****************************");
        System.out.println("Do zmiany hasła pozostało: " +PASSWORD_EXPIRATION_TIME);
        System.out.println("*****************************");
        System.out.println("Do zmiany hasła pozostało dni: " + date);
        Log log = new Log();
        log.setLogType(LOG_TITLE);
        log.setUser(user);
        log.setLogDesc("Logowanie użytkownika " + user.getName());
        LocalDateTime ldt = LocalDateTime.now();
        log.setCreatedDate(ldt);
        logServiceImpl.saveLog(log);
        return "/restrict/index";
    }
}
