package web.controllers;

import entity.Project;
import entity.Section;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Context;

import java.util.Map;

@Controller
@RequestMapping("/project")
public class SectionController {

    @PostMapping(value="/view", params={"id", "name"})
    public String addSection(@RequestParam String id, @RequestParam String name, Map<String, Object> model) {
        Project project = Context.getProject(id);
        Section section = new Section(name);
        project.addSection(section);

        model.put("project", project);
        model.put("sections", project.getSections());
        return "project/view";
    }

    @PostMapping(value="/view", params={"projectId", "sectionId", "delete"})
    public String removeSection(@RequestParam String projectId, @RequestParam String sectionId, Map<String, Object> model) {
        Project project = Context.getProject(projectId);
        project.removeSection(sectionId);

        model.put("project", project);
        model.put("sections", project.getSections());
        return "project/view";
    }


}
