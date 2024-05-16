package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.HospitalConfig;
import local.wpr.start.sios.service.impl.HospitalConfigServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MessagesController {
    private static final Logger LOG = LoggerFactory.getLogger(MessagesController.class);
//    @Autowired
//    HospitalConfigServiceimpl hospitalConfigServiceimpl;
//
//    @GetMapping("/restrict/messages")
//    private String goMessagesAdd(Model model){
//        List<HospitalConfig> hospitalConfigs = hospitalConfigServiceimpl.getAllActive();
//        model.addAttribute("hospitalConfigs", hospitalConfigs);
//        return "/restrict/messages";
//
//    }
}
