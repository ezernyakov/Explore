package web;

import entity.Project;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private static List<Project> projects = new ArrayList<>();

    public static Project getProject(String id) {
        for(Project project: projects) {
            if(project.getId().equals(id)) {
                return project;
            }
        }
        return null;
    }

    public static void addProject(Project newProject) {
        projects.removeIf(oldProject -> oldProject.getId().equals(newProject.getId()));
        projects.add(newProject);
    }

    public static void removeProject(String id) {
        projects.removeIf(project -> project.getId().equals(id));
    }

    public static List<Project> getProjectsList() {
        return projects;
    }
 }
