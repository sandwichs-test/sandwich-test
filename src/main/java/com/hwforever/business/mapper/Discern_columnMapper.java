package com.hwforever.business.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hwforever.business.model.Discern_column;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:41 2017/11/12
 */
@Mapper
public interface Discern_columnMapper {
    void insertDiscern_column(Discern_column discern_column);

   
    Discern_column selectDiscern_columnOneByCaseId(int case_id);
}
