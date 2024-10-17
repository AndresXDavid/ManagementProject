package co.edu.uptc.project.services;

import co.edu.uptc.project.model.Project;
import co.edu.uptc.project.model.Task;
import co.edu.uptc.project.model.User;

public class ServiceTask {

    public void createTask(Project project, String title, String description, String creationDate) {
        Task task = new Task(title, description, creationDate);
        project.addTask(task);
    }

    public void editTask(Task task, String newStatus) {
        task.updateStatus(newStatus);
    }

    public void deleteTask(Project project, Task task) {
        project.removeTask(task);
    }

    public void assignTaskToUser(Task task, User user) {
        task.assignUser(user);
    }
}
