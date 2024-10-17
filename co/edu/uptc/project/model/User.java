package co.edu.uptc.project.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Project> assignedProjects;
    private List<Task> assignedTasks;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.assignedProjects = new ArrayList<>();
        this.assignedTasks = new ArrayList<>();
    }

    public void assignProject(Project project) {
        this.assignedProjects.add(project);
    }

    public void assignTask(Task task) {
        this.assignedTasks.add(task);
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<Project> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}