package com.hwforever.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:34 2017/11/12
 */
@Controller
public class ModuleController {
    @RequestMapping("/modelCtrl")
    public String test(){
        return "modelCtrl";
    }
}
