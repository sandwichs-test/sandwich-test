package com.hwforever.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:35 2017/11/12
 */
@Controller
public class CaseController {
    @RequestMapping("/addExample")
    public String addExample(){
        return "addExample";
    }
    @RequestMapping("/searchExample")
    public String searchExample(){
        return "searchExample";
    }
    @RequestMapping("/runHis")
    public String runHis(){
        return "runHis";
    }
}
