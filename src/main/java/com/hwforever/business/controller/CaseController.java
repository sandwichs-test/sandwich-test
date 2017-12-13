package com.hwforever.business.controller;

import com.hwforever.business.model.Case;
import com.hwforever.business.model.Environment;
import com.hwforever.business.model.Project;
import com.hwforever.business.service.CaseService;
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
    private CaseService caseService;

    @Resource
    private EnvironmentService environmentService;

    @Resource
    private ProjectService projectService;

    @RequestMapping("/addExample")
    public String addExample(HttpServletRequest request){
        List<Environment> environments = environmentService.selectEnvironmentAll();
        request.setAttribute("envirs",environments);
        List<Project> projects = projectService.selectProjectAll();
        request.setAttribute("pros",projects);
        return "addExample";
    }

    @RequestMapping("/searchExample")
    public String searchExample(HttpServletRequest request){
        List<Case> cases= caseService.selectCaseAll();
        request.setAttribute("cases",cases);
        return "searchExample";
    }

    @RequestMapping("/selectExample")
    public String selectExample(HttpServletRequest request){
        Case _case = getCaseFromRequest(request);
        List<Case> cases = caseService.selectCaseLike(_case);
        request.setAttribute("cases",cases);
        return "searchExample";
    }

    @RequestMapping("/addCase")
    public String addCase(HttpServletRequest request){
        Case _case = getCaseFromRequest(request);
        caseService.insertCase(_case);
        return "redirect:/searchExample";
    }

    private Case getCaseFromRequest(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String case_type = request.getParameter("case_type");
        String service_id = request.getParameter("service_id");
        String service_name = request.getParameter("service_name");
        String protocol = request.getParameter("protocol");
        String environment = request.getParameter("environment");
        String projects = request.getParameter("projects");
        String element = request.getParameter("elements");
        String module = request.getParameter("modules");
        String nature = request.getParameter("nature");
        String platform = request.getParameter("platform");
        String request_message = request.getParameter("request_message");
        String response_message_hope = request.getParameter("response_message_hope");
        String response_message_actually = request.getParameter("response_message_actually");
        String description = request.getParameter("description");
        Integer serId = null;
        Integer proto = null;
        Integer pro_id = null;
        Integer envir_id = null;
        Integer ele_id = null;
        Integer mod_id = null;
        if (!"".equals(service_id) && service_id != null){
            serId = Integer.parseInt(service_id);
        }
        if (!"".equals(protocol) && protocol != null){
            proto = Integer.parseInt(protocol);
        }
        if (!"".equals(projects) && projects != null){
            pro_id = Integer.parseInt(projects);
        }
        if (!"".equals(environment) && environment != null){
            envir_id = Integer.parseInt(environment);
        }
        if (!"".equals(element) && element != null){
            ele_id = Integer.parseInt(element);
        }
        if (!"".equals(module) && module != null){
            mod_id = Integer.parseInt(module);
        }
        Case _case = new Case();
        _case.setCode(code);
        _case.setName(name);
        _case.setCase_type(case_type);
        _case.setService_id(serId);
        _case.setService_name(service_name);
        _case.setProtocol(proto);
        _case.setPro_id(pro_id);
        _case.setEnvir_id(envir_id);
        _case.setEle_id(ele_id);
        _case.setMod_id(mod_id);
        _case.setNature(nature);
        _case.setPlatform(platform);
        _case.setRequest_message(request_message);
        _case.setResponse_message_hope(response_message_hope);
        _case.setResponse_message_actually(response_message_actually);
        _case.setDescription(description);
        return _case;
    }
}
