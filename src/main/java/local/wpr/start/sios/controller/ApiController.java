package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.*;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    BranchServiceImpl branchService;
    @Autowired
    HospitalCategoryServiceImpl hospitalCategoryService;
    @Autowired
    HospitalConfigServiceimpl hospitalConfigServiceimpl;
    @Autowired
    HospitalCountyServiceImpl hospitalCountyService;
    @Autowired
    HospitalServiceImpl hospitalService;
    @Autowired
    ManagmentServiceImpl managmentService;
    @Autowired
    UserService userService;
    @Autowired
    ReportServiceImpl reportService;
    @Autowired
    SelectViewServiceImpl selectViewService;
    @Autowired
    MessagesServiceImpl messagesServiceImpl;
    @Autowired
    HospitalBranchClosedServiceImpl hospitalBranchClosedServiceImpl;
    @Autowired
    HospitalFailuresServiceImpl hospitalFailuresServiceImpl;
    @Autowired
    HospitalChoiceServiceImpl hospitalChoiceServiceImpl;



    @RequestMapping(value = "/users/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser(){
        try {
            System.out.println("Wchodzę tutaj ...");
            LOG.info("Pobrano dane z API /users/v1");
            return new ResponseEntity<List<User>>(userService.all(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /user/v1 : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/address/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> getAllAddress(){
        try {
            LOG.info("Pobrano dane z API /address/v1");
            return new ResponseEntity<List<Address>>(addressService.getAllAddress(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /address/v1 : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/branch/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Branch>> getAllBranch(){
        try {
            System.out.println("Wchodzę w Branch API");
            LOG.info("Pobrano dane z API /branch/v1");
            return new ResponseEntity<List<Branch>>(branchService.getAllBranch(), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /branch/v1 : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalCategory/v1",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalCategory>> getAllHospitalCategory(){
        try {
            System.out.println("Wchodzę w hospitalCategory API");
            LOG.info("Pobrano dane z API /hospitalCategory/v1");
            return new ResponseEntity<List<HospitalCategory>>(hospitalCategoryService.getAllHospitalCategory(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospitalCategory/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalCounty/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalCounty>> getAllCounty(){
        try {
            System.out.println("Wchodzę w County API");
            LOG.info("Pobrano dane z API /hospitalCounty/v1");
            return new ResponseEntity<List<HospitalCounty>>(hospitalCountyService.getAllHospitalCounty(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospitalCounty/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/reports/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> getAllReports(){
        try {
            System.out.println("Wchodzę do reports API");
            LOG.info("Pobrano dane z API /reports/v1");
            return new ResponseEntity<List<Report>>(reportService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Bład pobierania danych z API /reports/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/archivedReports/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> getAllArchived(){
        try {
            System.out.println("Wchodzę do archivedReports API");
            LOG.info("Pobrano dane z API /archivedReports/v1");
            return new ResponseEntity<List<Report>>(reportService.getAllArchived(), HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Błąd podczas pobierania danych z API /archivedReport/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalConfig/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalConfig>> getHospitalConfigByHispitalId(Principal principal){
        try {
            String name = principal.getName();
            User user = userService.findUserByUserName(name);
            Long hospId = user.getHospital().getHospitalId();
            return new ResponseEntity<List<HospitalConfig>>(hospitalConfigServiceimpl.getAllByHospitalId(hospId), HttpStatus.OK);
        } catch (Exception e){
            LOG.error("Błąd podczas pobierania danych z API /hospitalConfig/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalConfig/select/v1")
    public ResponseEntity<List<SelectView>> getHospitalToSelect(){
        try {
            return new ResponseEntity<List<SelectView>>(selectViewService.getAll(), HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Nie udało się pobrać danych z API: /hospitalConfig/select/v1 z powodu: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalConfig/search/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalConfig>> getHospitalConfigSearchBranchName(Principal principal, Long hospitalId, String term){
        try {
            String name = principal.getName();
            User user = userService.findUserByUserName(name);
            Long hospId = user.getHospital().getHospitalId();
            return new ResponseEntity<List<HospitalConfig>>(hospitalConfigServiceimpl.getByBranchName(hospitalId, term), HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Błąd podczas pobierania danych z API /hospitalConfig/search/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospital/messages/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Messages>> getAllActiveMessages(){
        try {
           return new ResponseEntity<List<Messages>>(messagesServiceImpl.getAllMessages(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospital/messages/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospital/hospitalBranchClosed/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalBranchClosed>> getAllBranchClosed(){
        try {
            return new ResponseEntity<List<HospitalBranchClosed>>(hospitalBranchClosedServiceImpl.getAll(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospital/hospitalBranchClosed/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospital/hospitalFailures/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalFailures>> getAllHospitalFailures(){
        try {
            return new ResponseEntity<List<HospitalFailures>>(hospitalFailuresServiceImpl.getAllHospitalFailures(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospital/hospitalFailures/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/hospitalChoice/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HospitalChoice>> getAllHospitalChoice(){
        try {
            return new ResponseEntity<List<HospitalChoice>>(hospitalChoiceServiceImpl.getAll(), HttpStatus.OK);
        }catch (Exception e) {
            LOG.error("Błąd podczas pobierania danych z API /hospitalChoice/v1" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//    @RequestMapping(value = "/hospitalConfig/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<HospitalConfig> getById(Long hospitalConfigId){
//        try {
//
//        }
//    }

//    @RequestMapping(value = "/newReport/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Report>> newReport(Principal principal){
//        String userName = principal.getName();
//        User user = userService.findUserByUserName(userName);
//        Long hospitalId = user.getHospital().getHospitalId();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDate localDate = localDateTime.toLocalDate();
//        LocalTime localTime = localDateTime.toLocalTime();
//        Date lastDate = reportService.getReportByDate(localDate).getDate();
//        System.out.println("Data z report service : " + lastDate);
////        if(lastDate == null) {
////            Report report = new Report();
////            reportService.
////        }
//        if ((hospitalId == null) || (hospitalId == 0)){
//
//        }
////        try {
////
////        }
//    }

}
