package com.example.requestparamsample.controller;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.requestparamsample.form.Form;

@Controller
public class RequestParamController {
    @GetMapping("show")
    public String showView(){
        return "entry";
    }
    /*
     * 
    @PostMapping("confirm")
    public String confirmView(
        Model model, @RequestParam String name, @RequestParam Integer age,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth
    ){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("birth", birth);

        return "confirm";
    }
    */
    @PostMapping("confirm")
    public String confirmView(Form f){
        //「Model」に格納するときに、明示的に「名前」をつけなければ、
        //格納するクラス名の「ローワーキャメルケース」で「Model」に格納される
        //ここでは、クラスFormに格納されたので、confirm2では${form.xx}になっている

        return "confirm2";
    }
}
