package co.edu.uptc.project.views;

import co.edu.uptc.project.model.HistoryChanges;
import co.edu.uptc.project.model.Task;

import java.util.List;

public class KanbanView {
    
    public void showBoard(List<Task> tasks) {
        System.out.println("Kanban Board:");
      
        System.out.println("\nPending Tasks:");
        showTasksByStatus(tasks, "pending");

        System.out.println("\nIn Progress Tasks:");
        showTasksByStatus(tasks, "in progress");

        System.out.println("\nCompleted Tasks:");
        showTasksByStatus(tasks, "completed");
    }

    private void showTasksByStatus(List<Task> tasks, String status) {
        boolean hasTasks = false;
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                hasTasks = true;
                System.out.println(" - " + task.getTitle() + " | Assigned to: " + 
                                   (task.getAssignedUser() != null ? task.getAssignedUser().getName() : "Unassigned"));
                // Mostrar historial de cambios si lo deseas
                showTaskHistory(task);
            }
        }
        if (!hasTasks) {
            System.out.println(" No tasks in this category.");
        }
    }

    private void showTaskHistory(Task task) {
        List<HistoryChanges> history = task.getHistory();
        if (history.isEmpty()) {
            System.out.println("   (No history available)");
            return;
        }

        System.out.println("   History:");
        for (HistoryChanges change : history) {
            System.out.println("    - " + change.toString());
        }
    }
}
