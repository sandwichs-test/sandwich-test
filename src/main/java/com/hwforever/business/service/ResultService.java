package com.hwforever.business.service;

import com.hwforever.business.mapper.ResultMapper;
import com.hwforever.business.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:54 2017/12/13
 */
@Service
public class ResultService {
    @Resource
    private ResultMapper resultMapper;

    public List<Result> selectResultAll() {
        return resultMapper.selectResultAll();
    }

    public List<Result> selectResultLike(Result result){
        return resultMapper.selectResultLike(result);
    }
}
