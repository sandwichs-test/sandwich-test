package com.hwforever.business.service;

import com.hwforever.business.mapper.ElementMapper;
import com.hwforever.business.mapper.ProjectMapper;
import com.hwforever.business.model.Element;
import com.hwforever.business.model.Project;
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
    private ProjectMapper projectMapper;

    @Resource
    private ElementMapper elementMapper;

    public boolean insertElement(Element element){
        element.setCode(CodeEnum.getCode(CodeEnum.ELEMENT_CODE));
        elementMapper.insertElement(element);
        element.setId(selectElementOnly(element).get(0).getId());
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
        if(("").equals(element.getPro_name())){
            element.setPro_name(null);
        }
        return elementMapper.selectElement(element);
    }

    public List<Element> selectElementOfProject(Integer id){
        return elementMapper.selectElementOfProjectId(id);
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
        //先更新element表
        elementMapper.updateElement(element);
        //根据element的项目名称，等到项目信息，主要为了得到项目id
        Project project = new Project();
        project.setName(element.getPro_name());
        project = projectMapper.selectProject(project).get(0);
        //根据element编码得到更新后的element信息，并设置项目id
        element = elementMapper.selectElementByCode(element).get(0);
        element.setPro_id(project.getId());
        //更新pro_ele_rel表
        elementMapper.updateProjectOfElement(element);
        return true;
    }

    public boolean deleteElement(Element element) {
        elementMapper.deleteElement(element);
        return true;
    }
}
