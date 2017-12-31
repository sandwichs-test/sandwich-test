package com.hwforever.business.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwforever.business.mapper.Discern_typeMapper;
import com.hwforever.business.model.Case;
import com.hwforever.business.model.Discern_type;

/**
 * @author： Likai
 * @Description：
 * @Date： Created in 16:27 2017/12/30
 */
@Service
public class Discern_typeService {
    @Resource
    private Discern_typeMapper discern_typeMapper;

    public boolean insertCase(Discern_type discern_type){
    	discern_typeMapper.insertDiscern_type(discern_type);
        return true;
    }

   
    public Discern_type selectDiscern_typeOneById(int id){
    	return discern_typeMapper.selectDiscern_typeOneById(id);
    }
}
