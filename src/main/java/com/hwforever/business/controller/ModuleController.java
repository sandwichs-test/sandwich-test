package com.hwforever.business.controller;

import com.hwforever.business.model.Module;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.ElementService;
import com.hwforever.business.service.ModuleService;
import com.hwforever.business.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/modelCtrl")
    public String modelCtrl(HttpServletRequest request){
        List<Project> projects = projectService.selectProjectWithElement();
        request.setAttribute("pros",projects);
        return "modelCtrl";
    }

    @RequestMapping("/addModule")
    public String addModule(HttpServletRequest request){
        Module module = getModule(request);
        return "";
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
        Integer ele_id = null;
        if(!("").equals(eleId) && eleId != null){
            ele_id = Integer.parseInt(eleId);
        }
        Module module = new Module();
        module.setCode(code);
        module.setName(name);
        module.setPro_id(pro_id);
        module.setEle_id(ele_id);
        return  module;
    }
}
