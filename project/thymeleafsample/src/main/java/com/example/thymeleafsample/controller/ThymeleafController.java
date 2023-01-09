package com.example.thymeleafsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    
    @GetMapping("show")
    public String showView(Model model){

        model.addAttribute("name", "太郎");
        return "useThymeleaf";
    }
}
      