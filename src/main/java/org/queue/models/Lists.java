package org.queue.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Lists {

    private static int incrementedValue = 0;

    @Id
    private String id;

    @NotNull
    private String name;

    private String description;

    @ElementCollection
    private List<String> elements;

    private @ManyToOne User user;

    public Lists() {
        incrementedValue++;
        this.setId("" + incrementedValue);
        this.elements = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addElements(String... elements) {
        this.elements.addAll(Arrays.asList(elements));
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "Lists{" +
                "name='" + name + '\'' +
                ", description=" + description  +
                '}';
    }

}
