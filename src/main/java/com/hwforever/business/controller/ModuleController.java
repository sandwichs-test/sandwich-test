package com.hwforever.business.controller;

import com.hwforever.business.aop.AuthorizedREST;
import com.hwforever.business.model.Element;
import com.hwforever.business.model.Module;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.ElementService;
import com.hwforever.business.service.ModuleService;
import com.hwforever.business.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:34 2017/11/12
 */
@Controller
public class ModuleController {
    @Resource
    private ProjectService projectService;

    @Resource
    private ElementService elementService;

    @Resource
    private ModuleService moduleService;

    @AuthorizedREST
    @RequestMapping("/modelCtrl")
    public String modelCtrl(HttpServletRequest request){
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        List<Module> modules = moduleService.selectModuleAll();
        request.setAttribute("modus",modules);
        return "modelCtrl";
    }


    @RequestMapping("/getModules")
    @ResponseBody
    public List<Element> getElements(Integer id){
        return moduleService.selectModuleOfElement(id);
    }

    @AuthorizedREST
    @RequestMapping("/addModule")
    public String addModule(HttpServletRequest request){
        Module module = getModule(request);
        System.out.println(module);
        moduleService.insertModule(module);
        return "redirect:/modelCtrl";
    }

    @AuthorizedREST
    @RequestMapping("/queryModule")
    public String queryModule(HttpServletRequest request){
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        Module module = getModule(request);
        List<Module> modules = moduleService.selectModule(module);
        request.setAttribute("modus",modules);
        return "modelCtrl";
    }

    @AuthorizedREST
    @RequestMapping("/updateModule")
    public String deleteModule(HttpServletRequest request){
        Module module = getModule(request);
        moduleService.updateModule(module);
        return "redirect:/modelCtrl";
    }

    private Module getModule(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String proId = request.getParameter("proId");
        String eleId = request.getParameter("eleId");
        Integer pro_id = null;
        if(!("").equals(proId) && proId != null){
            pro_id = Integer.parseInt(proId);
        }
        String proName = request.getParameter("proName");
        Integer ele_id = null;
        if(!("").equals(eleId) && eleId != null){
            ele_id = Integer.parseInt(eleId);
        }
        String eleName = request.getParameter("eleName");
        Module module = new Module();
        module.setCode(code);
        module.setName(name);
        module.setPro_id(pro_id);
        module.setEle_id(ele_id);
        module.setPro_name(proName);
        module.setEle_name(eleName);
        return  module;
    }
}
