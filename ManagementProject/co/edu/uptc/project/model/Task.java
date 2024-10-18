package co.edu.uptc.project.model;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String title;
    private String description;
    private String status;  // "pending", "in progress", "completed"
    private User assignedUser;
    private String creationDate;
    private String completionDate;
    private List<HistoryChanges> history;

    public Task(String title, String description, String creationDate) {
        this.title = title;
        this.description = description;
        this.status = "pending";  // Default status
        this.creationDate = creationDate;
        this.history = new ArrayList<>();
    }

    public void updateStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        registerHistory("Status changed from " + oldStatus + " to " + newStatus);
    }

    public void assignUser(User user) {
        this.assignedUser = user;
        registerHistory("Task assigned to " + user.getName());
    }

    //Registrar cambio en la tarea
    private void registerHistory(String change) {
        HistoryChanges historyChange = new HistoryChanges(this.creationDate);
        historyChange.registerChange(change);
        history.add(historyChange);
    }

 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        registerHistory("Title changed to " + title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        registerHistory("Description changed.");
    }

    public String getStatus() {
        return status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
        registerHistory("Assigned user changed to " + (assignedUser != null ? assignedUser.getName() : "none"));
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
        registerHistory("Completion date set to " + completionDate);
    }

    public List<HistoryChanges> getHistory() {
        return history;
    }
}
