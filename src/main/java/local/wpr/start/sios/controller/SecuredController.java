package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.model.HospitalReport;
import local.wpr.start.sios.service.impl.HospitalChoiceServiceImpl;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import local.wpr.start.sios.service.impl.HospitalReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SecuredController {
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
    @Autowired
    HospitalReportServiceImpl hospitalReportServiceImpl;

    @GetMapping("/restrict/messages")
    public String goMessages(){
        return "/restrict/messages";
    }

    @GetMapping("/wkrm/details/{id}")
    public String goDetailsById(@PathVariable Long id, Model model){
        HospitalReport hospitalReport = null;
        hospitalReport = hospitalReportServiceImpl.getById(id);
        System.out.println("Przekazane ID raportu wynosi: " + id);
        System.out.println("***********************************************");
        System.out.println("Pobrane dane z bazy: " + hospitalReport.getHospitalReportId() + hospitalReport.getStateA() + "; " + hospitalReport.getStateB());
//        HospitalConfig hospitalConfig = null;
//        hospitalConfig = hospitalConfigServiceimpl.getHospitalConfigById(id);
//        System.out.println("Hospital config: " + hospitalConfig.getHospitalConfigId()+"; " + hospitalConfig.getHospitalConfigDescription() + "; " + hospitalConfig.getBranch().getName());
        model.addAttribute("hospitalReport", hospitalReport);
        return "/wkrm/details";
    }

    @GetMapping("/wkrm/contact/{id}")
    public String goContactById(@PathVariable Long id, Model model){
        HospitalConfig hospitalConfig = null;
        hospitalConfig = hospitalConfigServiceimpl.getHospitalConfigById(id);
        System.out.println("Hospital config: " + hospitalConfig.getHospitalConfigId()+"; " + hospitalConfig.getHospitalConfigDescription() + "; " + hospitalConfig.getBranch().getName());
        model.addAttribute("hospitalConfig", hospitalConfig);
        return "/wkrm/contact";
    }

//    @GetMapping()
}
