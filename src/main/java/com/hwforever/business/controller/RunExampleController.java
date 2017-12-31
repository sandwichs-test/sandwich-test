package com.hwforever.business.controller;

import com.hwforever.business.model.Case;
import com.hwforever.business.model.Discern_column;
import com.hwforever.business.model.Discern_type;
import com.hwforever.business.model.Environment;
import com.hwforever.business.model.Project;
import com.hwforever.business.model.Result;
import com.hwforever.business.service.CaseService;
import com.hwforever.business.service.Discern_columnService;
import com.hwforever.business.service.Discern_typeService;
import com.hwforever.business.service.EnvironmentService;
import com.hwforever.business.service.ProjectService;
import com.hwforever.business.service.ResultService;
import com.hwforever.utils.XmlUtils;

import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author： Likai
 * @Description：
 * @Date： Created in 13:09 2017/12/30
 */
@Controller
public class RunExampleController {
    @Resource
    private CaseService caseService;

    @Resource
    private Discern_columnService discern_columnService;

    @Resource
    private Discern_typeService discern_typeService;

    @Resource
    private ResultService resultService;
    
    
    @RequestMapping("/runExample")
    public String runExample(HttpServletRequest request){
    	List<Case> cases = caseService.selectCaseAll();
        request.setAttribute("cases",cases);
        System.out.println(cases.size());
        System.out.println(cases.get(0));
        return "runExample";
    }

    @RequestMapping("/findExample")
    public String selectExample(HttpServletRequest request){
        Case _case = getCaseFromRequest(request);
        List<Case> cases = caseService.selectCaseLike(_case);
        request.setAttribute("cases",cases);
        return "runExample";
    }
    
    @RequestMapping("/run")
    @ResponseBody
    public Map< String, String> run(HttpServletRequest request,String case_id){
    	Date date=new Date();
    	long starttime=date.getTime();
//    	String case_id=request.getParameter("id");
    	Integer id=null;
//    	if(case_id !=null&&!"".equals(case_id)){
    	id=Integer.parseInt(case_id);
//    	}
    	Case oneCase = caseService.selectCaseOneById(id);
    	String request_message=oneCase.getRequest_message();
    	//获取特征字段
    	Discern_column discern_column=discern_columnService.selectDiscern_columnOneByCaseId(id);
    	String discern_name = discern_column.getDiscern_name();
    	String discern_value=discern_column.getDiscern_value();
    	String info = XmlUtils.getInfo(request_message, discern_name);
    	System.out.println("discern_name"+discern_name);
    	System.out.println("-----------"+info);
    	System.out.println(discern_column);
    	//获取特征类型
    	Integer discern_type_id = discern_column.getDiscern_type_id();
    	Result result=new Result();
    	result.setCase_id(oneCase.getId());
    	result.setSerial_number("");
    	result.setCase_code(oneCase.getCode());
    	result.setCase_name(oneCase.getName());
    	//result.setExecute_date();
    	Date date1=new Date();
    	long endtime=date1.getTime();
    	result.setExecute_time((int) (endtime-starttime));
    	result.setFailed_reason(null);
    	result.setRequest_message(request_message);
    	result.setResponse_code(null);//success fail
    	result.setType(oneCase.getCase_type());
    	//result.setUser_id(user_id);
    	//result.setUser_name(user_name);
    	
    	if(discern_type_id==1){
    		//匹配内容
    		if(discern_value.equals(info)){
    			//匹配成功,插入result成功状态
    			result.setResponse_code("SUCCESS");
    			
    		}else{
    			//匹配失败,插入result失败状态
    			result.setResponse_code("FAIL");
    			result.setFailed_reason("内容不匹配");
    		}
    		
    	}else if(discern_type_id==2){
    		//匹配长度
    		if(discern_value.length()==info.length()){
    			//匹配成功,插入result成功状态
    			result.setResponse_code("SUCCESS");
    		}else{
    			//匹配失败,插入result失败状态
    			result.setResponse_code("FAIL");
    			result.setFailed_reason("长度不匹配");
    		}
    	}
    	resultService.insertResult(result);
    	Map< String, String> map=new HashMap<>();
    	map.put("res", "1");
    	return map;
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
