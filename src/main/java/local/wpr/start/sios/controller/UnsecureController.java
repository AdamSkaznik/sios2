package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.model.UserView;
import local.wpr.start.sios.service.UserViewService;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.service.impl.UserViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UnsecureController {
    @Autowired
    UserViewServiceImpl userViewServiceImpl;
    @Autowired
    ReportServiceImpl reportServiceImpl;

    public UnsecureController(UserViewServiceImpl userViewServiceImpl) {
        this.userViewServiceImpl = userViewServiceImpl;
    }

    @GetMapping(value = "/unsecured/api/view/v1")
    public ResponseEntity<List<UserView>> getAllUserView(){
        Report report = null;
        report = reportServiceImpl.getLastReport();
        Long reportId = report.getId();
        System.out.println("Report id wynosi: " + reportId);
        try {
            return new ResponseEntity<List<UserView>>(userViewServiceImpl.all(reportId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
