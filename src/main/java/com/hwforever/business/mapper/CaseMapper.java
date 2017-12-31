package com.hwforever.business.mapper;

import com.hwforever.business.model.Case;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:41 2017/11/12
 */
@Mapper
public interface CaseMapper {
    void insertCase(Case aCase);

    List<Case> selectCaseAll();

    List<Case> selectCaseLike(Case aCase);
    
    Case selectCaseOneById(int id);
}
