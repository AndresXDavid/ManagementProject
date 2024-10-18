package co.edu.uptc.project.views;

import co.edu.uptc.project.model.Project;

import java.util.List;

public class Dashboard {
    public void showProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.println(project.getTitle() + ": " + project.getProgress() + "% completed");
        }
    }
}