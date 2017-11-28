package com.hwforever.business.mapper;

import com.hwforever.business.model.Element;
import com.hwforever.business.model.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:42 2017/11/12
 */
@Mapper
public interface ModuleMapper {
    List<Module> selectModuleAll();

    void insertModule(Module module);

    List<Module> selectModule(Module module);

    void updateModule(Module module);

    List<Element> selectModuleOfElementId(Integer id);
}
