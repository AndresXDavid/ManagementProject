package co.edu.uptc.project.views;

import co.edu.uptc.project.model.Task;

import java.util.List;

public class KanbanView {
    public void showBoard(List<Task> tasks) {
        System.out.println("Kanban Board:");
        for (Task task : tasks) {
            System.out.println(task.getTitle() + " - " + task.getStatus());
        }
    }
}