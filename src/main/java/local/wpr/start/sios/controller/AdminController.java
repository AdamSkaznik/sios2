package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.HospitalProceduresType;
import local.wpr.start.sios.service.impl.HospitalProceduresTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
//    @GetMapping()
    @Autowired
    HospitalProceduresTypeServiceImpl hospitalProceduresTypeServiceImpl;

    @GetMapping("/admin/index")
    private String goAdminIndex(){
        return "/admin/index";
    }

    @GetMapping("/admin/branch")
    public String goHospitalBranch(){
        return "/admin/branch";
    }
    @GetMapping("/admin/branch_add")
    public String goHospitalBranchAdd(){
        return "/admin/branch_add";
    }

    @GetMapping("/admin/hospital")
    public String goHospital(){
        return "/admin/hospital";
    }

    @GetMapping("/admin/hospital_add")
    public String goHospitalAdd(){
        return "/admin/hospital_add";
    }
    @GetMapping("/admin/hospitalCategory")
    public String goHospitalCategory(){
        return "/admin/hospitalCategory";
    }

    @GetMapping("/admin/hospitalCategory_add")
    public String goHospitalCategoryAdd(){
        return "/admin/hospitalCategory_add";
    }
    @GetMapping("/admin/hospitalCounty")
    public String goHospitalCounty(){
        return "/admin/hospitalCounty";
    }

    @GetMapping("/admin/logs")
    public String goAdminLogs(){
        return "/admin/logs";
    }
    @GetMapping("/admin/hospitalProceduresType")
    public String goHospitalProceduresType(){
        return "/admin/hospitalProceduresType";
    }

    @GetMapping("/admin/addHospitalProceduresType")
    public String goAddHospitalProceduresType(Model model){
        HospitalProceduresType hospitalProceduresType = new HospitalProceduresType();
        model.addAttribute("hospitalProceduresType", hospitalProceduresType);
        return "/admin/addHospitalProceduresType";
    }

    @PostMapping("/admin/saveHospitalProceduresType")
    public String saveHospitalProceduresType(@ModelAttribute("hospitalProceduresType")HospitalProceduresType hospitalProceduresType){
        HospitalProceduresType hospitalProceduresType1 = new HospitalProceduresType();
        hospitalProceduresType1.setActive(true);
        hospitalProceduresType1.setHospitalProceduresTypeDesc(hospitalProceduresType.getHospitalProceduresTypeDesc());
//        hospitalProceduresType1.setHospitalProceduresReception(0);
        String test = "góln";
        String por = hospitalProceduresType.getHospitalProceduresTypeDesc();
        boolean isContains = por.toLowerCase().contains(test.toLowerCase());
        System.out.println("Porównanie: czy jest ogóln - " + isContains);
        if(isContains == true){
            hospitalProceduresType1.setHospitalProceduresReception(0);
        } else {
            hospitalProceduresType1.setHospitalProceduresReception(1);
        }
        hospitalProceduresTypeServiceImpl.saveHospitalProceduresType(hospitalProceduresType1);
        LOG.info("Zapis do bazy danych typu procedur");
        return "redirect:/admin/index";

    }
}
