package com.hwforever.business.controller;

import com.hwforever.business.model.Element;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.ElementService;
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
public class ElementController {
    @Resource
    private ElementService elementService;

    @Resource
    private ProjectService projectService;

    @RequestMapping("/componentCtrl")
    public String componentCtrl(HttpServletRequest request){
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        List<Element> elements = elementService.selectElementAll();
        request.setAttribute("eles",elements);
        return "componentCtrl";
    }

    @RequestMapping("/addElement")
    public String addElement(HttpServletRequest request){
        Element element = getElement(request);
        elementService.insertElement(element);
        return "redirect:/componentCtrl";
    }
    @RequestMapping("/queryElement")
    public String queryElement(HttpServletRequest request){
        Element element = getElement(request);
        List<Element> elements = elementService.selectElement(element);
        request.setAttribute("eles",elements);
        return"componentCtrl";
    }

    @RequestMapping("/updateElement")
    public String updateElement(HttpServletRequest request){
        Element element = getElement(request);
        elementService.updateElement(element);
        return "redirect:/componentCtrl";
    }

    @RequestMapping("/deleteElement")
    public String deleteElement(HttpServletRequest request){
        Element element = getElement(request);
        elementService.deleteElement(element);
        return "redirect:/componentCtrl";
    }

    private Element getElement(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String ename = request.getParameter("ename");
        String proId = request.getParameter("proId");
        Integer pro_Id = null;
        if (!"".equals(proId)) {
            pro_Id = Integer.parseInt(proId);
        }
        Element element = new Element();
        element.setCode(code);
        element.setName(name);
        element.setEname(ename);
        element.setPro_id(pro_Id);
        return element;
    }
}