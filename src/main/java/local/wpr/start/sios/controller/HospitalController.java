package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
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

    @GetMapping("/hospital/addMessages")
    public String goAddMessages(){
        return "/hospital/addMessages";
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
        List<Branch> branches = branchServiceImpl.getAllBranch();
        model.addAttribute("branches", branches);
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
}
