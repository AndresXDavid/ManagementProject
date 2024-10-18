package co.edu.uptc.project.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private List<Task> taskList;
    private List<User> assignedUsers;

    public Project(String title, String description, String startDate, String endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskList = new ArrayList<>();
        this.assignedUsers = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }

    public void assignUser(User user) {
        this.assignedUsers.add(user);
    }

    public int getProgress() {
        int completedTasks = (int) taskList.stream().filter(t -> t.getStatus().equals("completed")).count();
        return (completedTasks * 100) / taskList.size();
    }

  

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", taskList=" + taskList +
                ", assignedUsers=" + assignedUsers +
                '}';
    }
}