package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Section {

    private final String id;
    private String name;
    private static AtomicInteger count;

    public Section(String name) {
        if(count == null) {
            count = new AtomicInteger(1);
        }
        this.id = "SC-" + count.getAndIncrement();
        this.name = name;
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
}
