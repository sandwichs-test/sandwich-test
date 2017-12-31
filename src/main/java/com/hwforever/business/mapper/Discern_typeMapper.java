package com.hwforever.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hwforever.business.model.Case;
import com.hwforever.business.model.Discern_type;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:41 2017/11/12
 */
@Mapper
public interface Discern_typeMapper {
    void insertDiscern_type(Discern_type discern_type);

    
    Discern_type selectDiscern_typeOneById(int id);
}
