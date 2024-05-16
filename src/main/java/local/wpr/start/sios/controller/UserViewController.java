package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.UserView;
import local.wpr.start.sios.service.impl.UserViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@CrossOrigin
@RestController
public class UserViewController {
//    @Autowired
//    UserViewServiceImpl userViewServiceImpl;
//    @Autowired
//
//
//    @RequestMapping(value = "/api/view/v1", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<UserView>> getAll(){
//
////        try {
////            System.out.println("Wchodzę do api ogólnego");
////            return new ResponseEntity<List<UserView>>(userViewServiceImpl.all(), HttpStatus.OK);
////        }catch (Exception e){
////            System.out.println("Błąd: " + e.getMessage());
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//    }
}
