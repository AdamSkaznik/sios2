package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.model.Views;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.service.impl.ViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class WkrmController {
    @Autowired
    ViewServiceImpl viewService;
    @Autowired
    ReportServiceImpl reportService;
//    @Autowired
//    ViewController viewController;
//
//    public WkrmController(ViewController viewController) {
//        this.viewController = viewController;
//    }

    @GetMapping("/wkrm/index")
    public String goIndex(){
        return "/wkrm/index";
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

    @GetMapping("/wkrm/details")
    public String goDetails(){
        return "/wkrm/details";
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
