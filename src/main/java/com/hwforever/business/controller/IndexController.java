<<<<<<< HEAD:src/main/java/com/hwforever/controller/IndexController.java
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
=======
package com.hwforever.business.controller;

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
>>>>>>> 4de5e0503c6a0613f068c83699dccb375b7dec8d:src/main/java/com/hwforever/business/controller/IndexController.java
