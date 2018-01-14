
package com.hwforever.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
    public String index(){
        return "index";
    }
	@RequestMapping("/index1")
    public String index1(){
        return "index1";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
