package co.edu.uptc.project.model;

public class Task {
    private String title;
    private String description;
    private String status;  // pending, in progress, completed
    private User assignedUser;
    private String creationDate;
    private String completionDate;

    public Task(String title, String description, String creationDate) {
        this.title = title;
        this.description = description;
        this.status = "pending";  // Default status
        this.creationDate = creationDate;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void assignUser(User user) {
        this.assignedUser = user;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", assignedUser=" + assignedUser +
                ", creationDate='" + creationDate + '\'' +
                ", completionDate='" + completionDate + '\'' +
                '}';
    }
}