package com.hwforever.business.service;

import com.hwforever.business.mapper.ElementMapper;
import com.hwforever.business.model.Element;
import com.hwforever.common.CodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 16:47 2017/11/12
 */
@Service
public class ElementService {
    @Resource
    private ElementMapper elementMapper;

    public boolean insertElement(Element element){
        element.setCode(CodeEnum.getCode(CodeEnum.ELEMENT_CODE));
        elementMapper.insertElement(element);
        List<Element> elements = selectElementOnly(element);
        Element elementT = elements.get(0);
        element.setId(elementT.getId());
        elementMapper.insertElementOfProject(element);
        return true;
    }
    public List<Element> selectElementAll(){
        return elementMapper.selectElementAll();
    }


    public List<Element> selectElement(Element element){
        if (("").equals(element.getCode())){
            element.setCode(null);
        }
        if (("").equals(element.getEname())){
            element.setEname(null);
        }
        if (("").equals(element.getName())){
            element.setName(null);
        }
        if(("").equals(element.getPro_id())){
            element.setPro_id(null);
        }
        return elementMapper.selectElement(element);
    }

    public List<Element> selectElementOnly(Element element){
        if (("").equals(element.getCode())){
            element.setCode(null);
        }
        if (("").equals(element.getEname())){
            element.setEname(null);
        }
        if (("").equals(element.getName())){
            element.setName(null);
        }
        if(("").equals(element.getPro_id())){
            element.setPro_id(null);
        }
        return elementMapper.selectElementOnly(element);
    }

    public boolean updateElement(Element element) {
        elementMapper.updateElement(element);
        return true;
    }

    public boolean deleteElement(Element element) {
        elementMapper.deleteElement(element);
        return true;
    }
}
