package com.hwforever.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwforever.business.mapper.Discern_columnMapper;
import com.hwforever.business.model.Case;
import com.hwforever.business.model.Discern_column;

/**
 * @author： Likai
 * @Description：
 * @Date： Created in 16:27 2017/12/30
 */
@Service
public class Discern_columnService {
    @Resource
    private Discern_columnMapper discern_columnMapper;

    public boolean insertDiscern_column(Discern_column discern_column){
        
    	discern_columnMapper.insertDiscern_column(discern_column);
        return true;
    }

    
    public Discern_column selectDiscern_columnOneByCaseId(int id){
    	return discern_columnMapper.selectDiscern_columnOneByCaseId(id);
    }
}
