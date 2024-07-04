package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.User;
import local.wpr.start.sios.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Date;

@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/restrict/account")
    public String goAccount(Principal principal, Model model){
         User user = userService.findUserByUserName(principal.getName());
        model.addAttribute("user", user);
        return "/restrict/account";
    }
    @PostMapping("/users/saveAccount")
    public String updateAccount(User user){
//        Date oryginal = user
        if(user.getPassword_tmp() != null){
            user.setPassword(user.getPassword_tmp());
            Date dt = new Date();
            user.setPasswordChangedTime(dt);
        }
        String name = user.getFirstName() + " " + user.getLastName();
        User user1 = userService.findUserByUserName(user.getUserName());
        Date dl = user1.getPasswordChangedTime();
        System.out.println("Data: " + dl.toString());
        user.setName(name);
        user.setPasswordChangedTime(user1.getPasswordChangedTime());
        userService.saveUser(user);
        return "window.history.back";
    }
}
