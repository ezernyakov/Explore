package web.controllers;

import entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.Context;

import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @GetMapping("/add")
    public String openAddProjectPage() {
        return "project/add";
    }

    @PostMapping("/add")
    public String createProject(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        Project project = new Project(name, description);
        Context.addProject(project);

        model.put("projects", Context.getProjectsList());
        return "project/list";
    }

    @PostMapping("/edit")
    public String openEditProjectPage(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                                      Map<String, Object> model) {

        Project project = Context.getProject(id);
        model.put("project", project);
        return "project/edit";
    }

    @PostMapping(value="/list", params={"id", "name", "description"})
    public String saveChanges(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                              Map<String, Object> model) {

        Project project = Context.getProject(id);
        if(project != null) {
            project.setName(name);
            project.setDescription(description);
        }
        Context.addProject(project);

        model.put("projects", Context.getProjectsList());
        return "project/list";
    }

    @PostMapping(value="/list", params = "id")
    public String removeProject(@RequestParam String id, Map<String, Object> model) {
        Context.removeProject(id);

        model.put("projects", Context.getProjectsList());
        return "project/list";
    }

    @GetMapping("/list")
    public String openListProjectPage(Map<String, Object> model) {
        model.put("projects", Context.getProjectsList());
        return "project/list";
    }

    @PostMapping(value="/view/*")
    public String openProjectView(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                                  Map<String, Object> model) {
        Project project = Context.getProject(id);
        model.put("project", project);
        return "project/view";
    }

}