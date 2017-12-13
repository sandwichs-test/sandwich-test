package com.hwforever.business.controller;

import com.hwforever.business.model.Result;
import com.hwforever.business.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:15 2017/12/13
 */
@Controller
public class HistoryController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/runHis")
    public String runHis(HttpServletRequest request){
        List<Result> results = resultService.selectResultAll();
        request.setAttribute("results",results);
        return "runHis";
    }

    @RequestMapping("/selectResults")
    public String selectResults(HttpServletRequest request){
        Result result = getResult(request);
        List<Result> results = resultService.selectResultLike(result);
        request.setAttribute("results",results);
        return "runHis";
    }

    private Result getResult(HttpServletRequest request) {
        String serial_number = request.getParameter("serial_number");
        String case_code = request.getParameter("case_code");
        String case_name = request.getParameter("case_name");
        String user_name = request.getParameter("user_name");
        Result result = new Result();
        result.setCase_code(case_code);
        result.setCase_name(case_name);
        result.setSerial_number(serial_number);
        result.setUser_name(user_name);
        return result;
    }
}
