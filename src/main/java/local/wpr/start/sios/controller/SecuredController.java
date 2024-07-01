package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.model.HospitalReport;
import local.wpr.start.sios.model.User;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import local.wpr.start.sios.service.impl.HospitalReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class SecuredController {
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
    @Autowired
    HospitalReportServiceImpl hospitalReportServiceImpl;
    @Autowired
    UserService userService;

    @GetMapping("/restrict/messages")
    public String goMessages(){
        return "/restrict/messages";
    }

    @GetMapping("/restrict/account")
    public String goAccount(Principal principal){
        User account = userService.findUserByUserName(principal.getName());
        System.out.println("Account: " + account);
        return ("/restrict/account");
    }

//    @GetMapping()
}
