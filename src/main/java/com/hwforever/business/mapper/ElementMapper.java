package com.hwforever.business.mapper;

import com.hwforever.business.model.Element;
import com.hwforever.business.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:41 2017/11/12
 */
@Mapper
public interface ElementMapper {
    void insertElement(Element element);

    List<Element> selectElement(Element element);

    List<Element> selectElementAll();

    void updateElement(Element element);

    void deleteElement(Element element);

    void insertElementOfProject(Element element);
}
