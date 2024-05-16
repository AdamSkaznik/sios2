package local.wpr.start.sios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
//    @GetMapping()

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
}
