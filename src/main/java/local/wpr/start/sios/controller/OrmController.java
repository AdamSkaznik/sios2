package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.Announcement;
import local.wpr.start.sios.model.User;
import local.wpr.start.sios.service.UserService;
import local.wpr.start.sios.service.impl.AnnouncementServiceImpl;
import local.wpr.start.sios.service.impl.MessagesServiceImpl;
import local.wpr.start.sios.service.impl.PrivateMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class OrmController {
    @Autowired
    UserService userService;
    @Autowired
    PrivateMessageServiceImpl privateMessageService;
    @Autowired
    AnnouncementServiceImpl announcementServiceImpl;
    @Autowired
    MessagesServiceImpl messagesServiceImpl;
//    @GetMapping("/orm/index")
//    public String goOrmHome(){
//        return "/orm/index";
//    }

    @GetMapping("/orm/index")
    public String goHospitalIndex(HttpSession httpSession, Principal principal, Model model){
        String uName = principal.getName();
        User user = userService.findUserByUserName(uName);
        System.out.println("User Id: " + user.getId());
        Long uId = Long.valueOf(user.getId());
        Integer privateMess = privateMessageService.countPrivateMessages(uId);
        Announcement announcement = announcementServiceImpl.getLast();
        if(announcement != null){
            model.addAttribute("announcement", announcement);
            System.out.println("Jest ogłoszenie");
            System.out.println("Ogłoszenie : " + announcement);
        }
        httpSession.setAttribute("privateMess", privateMess);
//        Messages messages = messagesServiceImpl.getAllMessages();
        model.addAttribute("messagesList", messagesServiceImpl.getAllMessages());
        model.addAttribute("user", user);
        return "/orm/index";
    }


    @GetMapping("/orm/analize")
    public String goAnalize(){
        return "/orm/analize";
    }
}
