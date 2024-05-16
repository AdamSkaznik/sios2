package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.Report;
import local.wpr.start.sios.model.Views;
import local.wpr.start.sios.service.impl.ReportServiceImpl;
import local.wpr.start.sios.service.impl.ViewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@RestController
public class ViewController {
    private static final Logger LOG = LoggerFactory.getLogger(ViewController.class);
   @Autowired
    ReportServiceImpl reportServiceImpl;
    @Autowired
    ViewServiceImpl viewServiceImpl;

//    public ViewController(ViewServiceImpl viewServiceImpl) {
//        this.viewServiceImpl = viewServiceImpl;
//    }

    @GetMapping("/api/viewsWkrm/v1")
    public ResponseEntity<List<Views>> getAllWkrm(){
        Report report = null;
        report = reportServiceImpl.getLastReport();
        Long reportId = report.getId();
        System.out.println("Report id wynosi: " + reportId);
        try {
            return new ResponseEntity<List<Views>>(viewServiceImpl.getAllWkrm(reportId), HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Błąd podczas pobierania danych z API viewsWkrm. " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/viewsWkrmHospitalReport/v1")
    public ResponseEntity<List<Views>> getByReportId(@RequestParam Long id) throws Exception{
        System.out.println("ID z API wynosi: " + id);
        try {
            return new ResponseEntity<List<Views>>(viewServiceImpl.getAllWkrm(id), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API viewsWkrmHospitalReports. " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//    @GetMapping("/wkrm/reportDetails/{id}")
//    public ModelAndView getReportDetails(ModelAndView mvc, @PathVariable Long id){
//        try {
//           List<Views> newViews = new ResponseEntity<List<Views>>(viewServiceImpl.getAllWkrm(id), HttpStatus.OK).getBody();
//        }catch (Exception e){
//            List<Views> newViews = (List<Views>) new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        mvc.setViewName("/wkrm/reportDetails");
//        mvc.addObject("newViews", new Object());
//        return mvc;
//    }
}
