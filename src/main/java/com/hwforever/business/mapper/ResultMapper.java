package com.hwforever.business.mapper;

import com.hwforever.business.model.Result;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:54 2017/12/13
 */
@Mapper
public interface ResultMapper {
    List<Result> selectResultAll();
}
