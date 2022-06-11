package com.webProject.ThymeleafWebProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("*")
public class LoginController {
    Logger logger= LoggerFactory.getLogger(LoginController.class);
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("name","Ram Saraswat");
        model.addAttribute("date", LocalDate.now());
        logger.info("inside the index method...");
        return "index";
    }

    @RequestMapping(value = "")
    public String index(){
        return "forward:/index";
    }
}
