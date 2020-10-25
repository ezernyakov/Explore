package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Project {

    private String id;
    private String name;
    private String description;
    private static AtomicInteger count;

    public Project(String name, String description) {
        if(count == null) {
            count = new AtomicInteger(0);
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
}
