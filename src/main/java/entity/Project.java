package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Project {

    private final String id;
    private String name;
    private String description;
    private static AtomicInteger count;
    private List<Section> sections = new ArrayList<>();

    public Project(String name, String description) {
        if(count == null) {
            count = new AtomicInteger(1);
        }
        this.id = "PR-" + count.getAndIncrement();
        this.name = name;
        this.description = description;
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void removeSection(String id) {
        sections.removeIf(section -> section.getId().equals(id));
    }

    public void editSection(String id, String name) {
        for(Section section: sections) {
            if(section.getId().equals(id)) {
                sections.remove(section);
                section.setName(name);
                sections.add(section);
            }
        }
    }
}
