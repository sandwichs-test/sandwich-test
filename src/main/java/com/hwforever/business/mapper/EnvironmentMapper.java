package com.hwforever.business.mapper;

import com.hwforever.business.model.Environment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 10:17 2017/11/10
 */
@Mapper
public interface EnvironmentMapper {
    void insertEnvironment(Environment environment);

    List<Environment> selectEnvironment(Environment environment);
}