package com.hwforever.business.service;

import com.hwforever.business.mapper.ProjectMapper;
import com.hwforever.business.model.Project;
import com.hwforever.common.CodeEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 13:10 2017/11/12
 */
@Service
public class ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    public boolean insertProject(Project project){
        project.setCode(CodeEnum.getCode(CodeEnum.PROJECT_CODE));
        projectMapper.insertProject(project);
        return true;
    }
    public List<Project> selectProjectAll(){
        return projectMapper.selectProjectAll();
    }

    public List<Project> selectProjectWithElement(){
        return projectMapper.selectProjectWithElement();
    }

    public List<Project> selectProject(Project project){
        if (("").equals(project.getCode())){
            project.setCode(null);
        }
        if (("").equals(project.getDescription())){
            project.setDescription(null);
        }
        if (("").equals(project.getEname())){
            project.setEname(null);
        }
        if (("").equals(project.getName())){
            project.setName(null);
        }
        return projectMapper.selectProject(project);
    }

    public boolean updateProject(Project project) {
        projectMapper.updateProject(project);
        return true;
    }

    public boolean deleteProject(Project project) {
        projectMapper.deleteProject(project);
        return true;
    }
}
