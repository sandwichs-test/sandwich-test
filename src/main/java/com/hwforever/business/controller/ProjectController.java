package com.hwforever.business.controller;

import com.hwforever.business.model.Environment;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 11:56 2017/11/12
 */
@Controller
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("/projectCtrl")
    public String projectCtrl(HttpServletRequest request){
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        return "projectCtrl";
    }

    @RequestMapping("/addProject")
    public String addProject(HttpServletRequest request){
        Project project = getProject(request);
        System.out.println(project);
        projectService.insertProject(project);
        return "redirect:/projectCtrl";
    }
    @RequestMapping("/queryProject")
    public String queryProject(HttpServletRequest request){
        Project project = getProject(request);
        List<Project> projects = projectService.selectProject(project);
        request.setAttribute("pros",projects);
        return"projectCtrl";
    }

    @RequestMapping("/updateProject")
    public String updateProject(HttpServletRequest request){
        Project project = getProject(request);
        projectService.updateProject(project);
        return "redirect:/projectCtrl";
    }

    @RequestMapping("deleteProject")
    public String deleteProject(HttpServletRequest request){
        Project project = getProject(request);
        projectService.deleteProject(project);
        return "redirect:/projectCtrl";
    }

    private Project getProject(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String ename = request.getParameter("ename");
        String description = request.getParameter("description");
        Project project = new Project();
        project.setCode(code);
        project.setName(name);
        project.setEname(ename);
        project.setDescription(description);
        return project;
    }
}
