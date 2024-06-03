package com.sjpa.service;

import com.sjpa.dao.ProjectDao;
import com.sjpa.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Transactional(readOnly = false)
    public int newProject(Project project) {
        return projectDao.saveProject(project);
    }

    @Transactional(readOnly = false)
    public boolean updateTeamSizeForaProject(int projectNo, int teamSize) {
        projectDao.updateProject(projectNo, teamSize);
        return true;
    }

    @Transactional(readOnly = true)
    public List<Project> getProjectsByTeamSize(int teamSize) {
        return projectDao.getProjectsByTeamSize(teamSize);
    }

    @Transactional(readOnly = true)
    public List<Project> getProjectsByDuration(int duration) {
        return projectDao.getProjectsByDuration(duration);
    }

    public List<Project> findProjectsByClient(String clientName) {
        return projectDao.getProjectsByClient(clientName);
    }
}
