package local.wpr.start.sios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrmController {
    @GetMapping("/orm/index")
    public String goOrmHome(){
        return "/orm/index";
    }

    @GetMapping("/orm/analize")
    public String goAnalize(){
        return "/orm/analize";
    }
}
