package com.hwforever.business.service;


import com.hwforever.business.mapper.EnvironmentMapper;
import com.hwforever.business.model.Environment;
import com.hwforever.common.CodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public boolean insertEnvironment(Environment environment){
        environment.setCode(CodeEnum.getCode(CodeEnum.ENVIRONMENT_CODE));
        environmentMapper.insertEnvironment(environment);
        return true;
    }

    public List<Environment> selectEnvironmentAll(){
        return environmentMapper.selectEnvironmentAll();
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

    public boolean updateEnvironment(Environment environment) {
        environmentMapper.updateEnvironment(environment);
        return true;
    }

    public boolean deleteEnvironment(Environment environment) {
        environmentMapper.deleteEnvironment(environment);
        return true;
    }
}
