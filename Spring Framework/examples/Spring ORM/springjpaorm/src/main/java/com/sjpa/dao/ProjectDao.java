package com.sjpa.dao;

import com.sjpa.entities.Project;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDao {
    private final String JPQL_GET_PROJECTS_BY_TEAM_SIZE = "from Project p where p.teamSize >= :teamSize";

    @Autowired
    private JpaTemplate jpaTemplate;

    public int saveProject(Project project) {
        jpaTemplate.persist(project);
        return project.getProjectNo();
    }

    public void updateProject(int projectNo, int teamSize) {
        Project project = null;

        project = jpaTemplate.find(Project.class, projectNo);
        project.setTeamSize(teamSize);
        jpaTemplate.merge(project);
    }

    public List<Project> getProjectsByTeamSize(int teamSize) {
        return jpaTemplate.findByNamedParams(JPQL_GET_PROJECTS_BY_TEAM_SIZE, Map.of("teamSize", teamSize));
    }

    public List<Project> getProjectsByDuration(int duration) {
        return jpaTemplate.findByNamedQueryAndNamedParams("getProjectsByDuration", Map.of("duration", duration));
    }

    public List<Project> getProjectsByClient(String clientName) {
        return (List<Project>) jpaTemplate.execute(entityManager -> {

            List<Project> projects = null;
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Project> cq = builder.createQuery(Project.class);
            Root<Project> root= cq.from(Project.class);
            cq.select(root).where(builder.like(root.get("clientName"), clientName));
            TypedQuery<Project> tq = entityManager.createQuery(cq);
            projects = tq.getResultList();

            return projects;
        });
    }
}













