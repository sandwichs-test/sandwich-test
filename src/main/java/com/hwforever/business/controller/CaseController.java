package com.hwforever.business.controller;

import com.hwforever.business.model.Case;
import com.hwforever.business.model.Environment;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.EnvironmentService;
import com.hwforever.business.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:35 2017/11/12
 */
@Controller
public class CaseController {
    @Resource
    private EnvironmentService environmentService;

    @Resource
    private ProjectService projectService;

    @RequestMapping("/addExample")
    public String addExample(HttpServletRequest request){
        List<Environment> environments = environmentService.selectEnvironmentAll();
        request.setAttribute("envirs",environments);
        for (Environment e:environments) {
            System.out.println(e);
        }
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        for (Project p : projects){
            System.out.println(p);
        }
        return "addExample";
    }

    @RequestMapping("/addCase")
    public String addCase(HttpServletRequest request){
        return null;
    }

    private Case getCaseFromRequest(HttpServletRequest request){
        String name = request.getParameter("name");
        String case_type = request.getParameter("cast_type");
        return new Case();
    }
}
