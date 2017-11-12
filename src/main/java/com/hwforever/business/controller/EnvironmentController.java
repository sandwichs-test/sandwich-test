package com.hwforever.business.controller;

import com.hwforever.business.model.Environment;
import com.hwforever.business.service.EnvironmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 9:37 2017/11/10
 */
@Controller
public class EnvironmentController {
    @Resource
    private EnvironmentService environmentService;

    @RequestMapping("/environmentInfoCtrl")
    public String environmentInfoCtrl(HttpServletRequest request){
        List<Environment> environments = environmentService.selectEnvironmentAll();
        request.setAttribute("envirs",environments);
        return "environmentInfoCtrl";
    }

    @RequestMapping("/addEnvironment")
    public String addEnvironment(HttpServletRequest request){
        Environment environment = getEnvironment(request);
        environmentService.insertEnvironment(environment);
        return "redirect:/environmentInfoCtrl";
    }

    @RequestMapping("/queryEnvironment")
    public String queryEnvironment(HttpServletRequest request){
        Environment environment = getEnvironment(request);
        List<Environment> environments = environmentService.selectEnvironment(environment);
        request.setAttribute("envirs",environments);
        return"environmentInfoCtrl";
    }

    @RequestMapping("/updateEnvironment")
    public String updateEnvironment(HttpServletRequest request){
        Environment environment = getEnvironment(request);
        environmentService.updateEnvironment(environment);
        return "redirect:/environmentInfoCtrl";
    }

    @RequestMapping("/deleteEnvironment")
    public String deleteEnvironment(HttpServletRequest request){
        Environment environment = getEnvironment(request);
        environmentService.deleteEnvironment(environment);
        return "redirect:/environmentInfoCtrl";
    }

    private Environment getEnvironment(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String ip = request.getParameter("ip");
        String portstr = request.getParameter("port");
        Integer port = null;
        if (!"".equals(portstr)) {
            port = Integer.parseInt(portstr);
        }
        String url = request.getParameter("url");
        Environment environment = new Environment();
        environment.setCode(code);
        environment.setIp(ip);
        environment.setName(name);
        environment.setPort(port);
        environment.setUrl(url);
        return environment;
    }
}
