package com.hwforever.business.service;


import com.hwforever.business.mapper.EnvironmentMapper;
import com.hwforever.business.model.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 9:51 2017/11/10
 */
@Service
public class EnvironmentService {
    @Resource
    private EnvironmentMapper environmentMapper;

    public void insertEnvironment(Environment environment){
        environmentMapper.insertEnvironment(environment);
    }

    public List<Environment> selectEnvironment(Environment environment){
        if (environment.getCode().equals("")){
            environment.setCode(null);
        }
        if (environment.getIp().equals("")){
            environment.setIp(null);
        }
        if (environment.getUrl().equals("")){
            environment.setUrl(null);
        }
        if (environment.getName().equals("")){
            environment.setName(null);
        }
        return environmentMapper.selectEnvironment(environment);
    }
}
