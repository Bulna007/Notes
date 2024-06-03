package com.sjpa.test;

import com.sjpa.config.RootConfig;
import com.sjpa.entities.Project;
import com.sjpa.service.ProjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class SpringJpaORMTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
//        Project project = new Project();
//        project.setProjectName("Enterprise Billing");
//        project.setDuration(36);
//        project.setClientName("Tata");
//        project.setStartDate(LocalDate.now());
//        project.setTeamSize(10);

        ProjectService projectService = applicationContext.getBean(ProjectService.class);
        /*int projectNo = projectService.newProject(project);
        System.out.println("project no : " + projectNo);*/
        //projectService.updateTeamSizeForaProject(1, 20);
        //projectService.getProjectsByTeamSize(6).forEach(System.out::println);
        //projectService.getProjectsByDuration(24).forEach(System.out::println);
        projectService.findProjectsByClient("Tesla").forEach(System.out::println);
    }
}
