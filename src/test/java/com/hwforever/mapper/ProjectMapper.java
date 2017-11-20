package com.hwforever.business.mapper;

import com.hwforever.business.model.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 13:38 2017/11/12
 */
@Mapper
public interface ProjectMapper {
    void insertProject(Project project);

    List<Project> selectProject(Project project);

    List<Project> selectProjectAll();

    //List<Project> selectProjectWithElement();

    void updateProject(Project project);

    void deleteProject(Project project);
}
