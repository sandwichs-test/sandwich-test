package com.hwforever.business.mapper;

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
}
