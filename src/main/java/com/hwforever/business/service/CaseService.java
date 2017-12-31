package com.hwforever.business.service;

import com.hwforever.business.mapper.CaseMapper;
import com.hwforever.business.model.Case;
import com.hwforever.common.CodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 16:27 2017/12/12
 */
@Service
public class CaseService {
    @Resource
    private CaseMapper caseMapper;

    public boolean insertCase(Case _case){
        _case.setCode(CodeEnum.getCode(CodeEnum.CASE_CODE));
        caseMapper.insertCase(_case);
        return true;
    }

    public List<Case> selectCaseAll() {
        return caseMapper.selectCaseAll();
    }

    public List<Case> selectCaseLike(Case aCase) {
        return caseMapper.selectCaseLike(aCase);
    }
    
    public Case selectCaseOneById(int id){
    	return caseMapper.selectCaseOneById(id);
    }
}
