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
        for(Result r : results){
            System.out.println(r.toString());
        }
        request.setAttribute("results",results);
        return "runHis";
    }
}
