package com.NaserGharbieh.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Capitalize {
    String smallString;
@GetMapping("/capitalize/{smalltext}")
    public String capitalize(Model veiwCapitalize, @PathVariable String smalltext){

//    veiwCapitalize.addAttribute("text",smalltext.toUpperCase());
    veiwCapitalize.addAttribute("text",smalltext.toUpperCase());
    return "capitalized.html";
}
}
