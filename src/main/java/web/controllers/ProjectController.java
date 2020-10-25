package web.controllers;

import entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private List<Project> projects = new ArrayList<>();
    private Project currentProject;

    @GetMapping("/add")
    public String openAddProjectPage() {
        return "project/add";
    }

    @PostMapping("/add")
    public String createProject(@RequestParam String name, @RequestParam String description) {
        Project project = new Project(name, description);
        projects.add(project);
        return "main";
    }

    @PostMapping("/edit")
    public String openEditProjectPage(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                                      Map<String, Object> model) {
        currentProject = new Project(id, name, description);
        model.put("project", currentProject);
        return "project/edit";
    }

    @PostMapping(value="/list", params={"id", "name", "description"})
    public String saveChanges(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                              Map<String, Object> model) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                project.setName(name);
                project.setDescription(description);
            }
        }

        model.put("projects", projects);
        return "project/list";
    }

    @PostMapping(value="/list", params = "id")
    public String removeProject(@RequestParam String id, Map<String, Object> model) {
        projects.removeIf(project -> project.getId().equals(id) );

        model.put("projects", projects);
        return "project/list";
    }

    @GetMapping("/list")
    public String openListProjectPage(Map<String, Object> model) {
        model.put("projects", projects);
        return "project/list";
    }

}