package com.hwforever.business.mapper;

import com.hwforever.business.model.Element;
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

    /**
     * @descriptiong: 根据条件查询
     * @param: element
     */
    List<Element> selectElement(Element element);

    /**
     * @descriptiong: 查询所有
     * @param: element
     */
    List<Element> selectElementAll();

    void updateElement(Element element);

    void updateProjectOfElement(Element element);

    void deleteElement(Element element);

    void insertElementOfProject(Element element);

    List<Element> selectElementOfProjectId(Integer id);

    /**
     * @descriptiong: 只查询element表，用于新增组件逻辑插入
     * @param: element
     */
    List<Element> selectElementOnly(Element element);

    List<Element> selectElementByCode(Element element);
}
