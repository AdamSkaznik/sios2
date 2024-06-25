package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class WkrmController {
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
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
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
        model.addAttribute("messagesList", messagesServiceImpl.getActiveMessages());
        model.addAttribute("user", user);
        return "/wkrm/index";
    }

    @GetMapping("/wkrm/detailsMessage/{id}")
    public String goWkrmDetailsMessage(Model model, @PathVariable Long id){
        Messages messages = messagesServiceImpl.getMessagesById(id);
        model.addAttribute("messages", messages);
        return "/wkrm/detailsMessage";
    }
    @GetMapping("/wkrm/editMessage/{id}")
    public String goWkrmEditMessage(Model model, @PathVariable Long id){
        model.addAttribute("messages", messagesServiceImpl.getMessagesById(id));
        return "/wkrm/editMessage";
    }

    @GetMapping("/wkrm/reportHospitalTable")
    public String goReportHospitalTable(){
        return "/wkrm/reportHospitalTable";
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

//    @GetMapping("/wkrm/contact")
//    public String goContact(){
//        return "/wkrm/contact";
//    }
//    @GetMapping("/wkrm/reportDetails/{id}")
//    public Object goReportDetails(ModelAndView mav, @PathVariable Long id){
//        List<Views> viewsObiect = viewService.getAllWkrm(id);
//        try {
//            mav.setViewName("/wkrm/reportDetails");
//            mav.addObject("viewsObiect", viewsObiect);
//            return mav;
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
