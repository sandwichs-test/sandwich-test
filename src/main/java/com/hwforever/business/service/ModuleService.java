package com.hwforever.business.service;

import com.hwforever.business.mapper.ModuleMapper;
import com.hwforever.business.model.Module;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 16:47 2017/11/13
 */
@Service
public class ModuleService {
    @Resource
    private ModuleMapper moduleMapper;

    public List<Module> selectModuleAll(){
        return moduleMapper.selectModuleAll();
    }
}
