package web.controllers;

import entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private List<Project> projects = new ArrayList<>();

    @GetMapping("/add")
    public String addProject()  {
        return "project/add";
    }

    @PostMapping("/add")
    public String saveProject(@RequestParam String name, @RequestParam String description) {
        Project project = new Project(name, description);
        projects.add(project);
        return "main";
    }

    @GetMapping("/edit")
    public String editProject(Map<String, Object> model)  {

        return "project/edit";
    }

    @GetMapping("/remove")
    public String removeProject(Map<String, Object> model)  {

        return "project/remove";
    }

    @GetMapping("/list")
    public String getListProject(Map<String, Object> model)  {
        model.put("projects", projects);
        return "project/list";
    }

}
