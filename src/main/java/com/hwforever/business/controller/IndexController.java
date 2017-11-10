
package com.hwforever.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
    public String index(){
        return "index";
    }

	@RequestMapping("/addExample")
    public String addExample(){
        return "addExample";
    }

	@RequestMapping("/componentCtrl")
    public String componentCtrl(){
        return "componentCtrl";
    }

	@RequestMapping("/environmentInfoCtrl")
    public String environmentInfoCtrl(){
        return "environmentInfoCtrl";
    }

	@RequestMapping("/modelCtrl")
    public String test(){
        return "modelCtrl";
    }

	@RequestMapping("/projectCtrl")
    public String projectCtrl(){
        return "projectCtrl";
    }


}
