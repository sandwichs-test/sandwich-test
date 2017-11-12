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
    public @ResponseBody String addEnvironment(HttpServletRequest request){
        String name = request.getParameter("name");
        String ip = request.getParameter("ip");
        String portstr = request.getParameter("port");
        Integer port = Integer.parseInt(portstr);
        String url = request.getParameter("url");
        Environment environment = new Environment();
        environment.setIp(ip);
        environment.setCode(LocalDate.now().toString().replace("-","")+ LocalTime.now().toString().replace(":","").substring(0,6));
        environment.setName(name);
        environment.setPort(port);
        environment.setUrl(url);
        environmentService.insertEnvironment(environment);
        return "success";
    }

    @RequestMapping("/queryEnvironment")
    public String queryEnvironment(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String ip = request.getParameter("ip");
        String portstr = request.getParameter("port");
        Integer port = null;
        if (!"".equals(portstr)) {
            port = Integer.parseInt(portstr);
        }
        String url = request.getParameter("url");
        System.out.println(code+"dd"+name+"dd"+ip+"dd"+port+"dd"+url);
        Environment environment = new Environment();
        environment.setCode(code);
        environment.setIp(ip);
        environment.setName(name);
        environment.setPort(port);
        environment.setUrl(url);
        List<Environment> environments = environmentService.selectEnvironment(environment);
        for (Environment environment1 : environments){
            System.out.println(environment1);
        }
        request.setAttribute("envirs",environments);
        return"environmentInfoCtrl";
    }

    public String updateEnvironmentController(){

        return "environmentInfoCtrl";
    }
}
