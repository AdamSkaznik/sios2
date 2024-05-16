package local.wpr.start.sios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NfzController {
    @GetMapping("/nfz/index")
    public String goNfzHome(){
        return "/nfz/index";
    }
}
