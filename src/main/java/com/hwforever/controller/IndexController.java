package com.hwforever.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/aa")
    public String test(){
        System.out.println("asdf");
        return "hello";
    }
}
