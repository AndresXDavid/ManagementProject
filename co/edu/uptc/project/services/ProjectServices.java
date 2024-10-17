package co.edu.uptc.project.services;

import co.edu.uptc.project.model.Project;
import co.edu.uptc.project.model.Task;
import co.edu.uptc.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProjectServices {
    private final List<Project> projects;

    public ProjectServices() {
        this.projects = new ArrayList<>();
    }

    public void createProject(String title, String description, String startDate, String endDate) {
        Project project = new Project(title, description, startDate, endDate);
        projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public void addTaskToProject(Project project, Task task) {
        project.addTask(task);
    }

    public void assignUserToProject(Project project, User user) {
        project.assignUser(user);
    }

    public List<Project> getProjects() {
        return projects;
    }
}