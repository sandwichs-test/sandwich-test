package com.hwforever.business.service;

import com.hwforever.business.mapper.ElementMapper;
import com.hwforever.business.mapper.ModuleMapper;
import com.hwforever.business.mapper.ProjectMapper;
import com.hwforever.business.model.Element;
import com.hwforever.business.model.Module;
import com.hwforever.business.model.Project;
import com.hwforever.common.CodeEnum;
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

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private ElementMapper elementMapper;

    public List<Module> selectModuleAll(){
        return moduleMapper.selectModuleAll();
    }

    public boolean insertModule(Module module) {
        module.setCode(CodeEnum.getCode(CodeEnum.MODULE_CODE));
        moduleMapper.insertModule(module);
        return true;
    }

    public List<Module> selectModule(Module module) {
        if(("").equals(module.getCode())){
            module.setCode(null);
        }
        if(("").equals(module.getName())){
            module.setName(null);
        }
        if(("").equals(module.getPro_name())){
            module.setPro_name(null);
        }
        if(("").equals(module.getEle_name())){
            module.setEle_name(null);
        }
        return  moduleMapper.selectModule(module);
    }

    public boolean updateModule(Module module) {
        moduleMapper.updateModule(module);
        return true;
    }

    public List<Element> selectModuleOfElement(Integer id) {
        return moduleMapper.selectModuleOfElementId(id);
    }
}
