package co.edu.uptc.project.persistence;

import co.edu.uptc.project.model.Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSONManager {
    private static final String PROJECTS_FILE = "projects.json";

    public static void saveProjectsToJSON(List<Project> projects) throws IOException {
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(PROJECTS_FILE);
        gson.toJson(projects, writer);
        writer.close();
    }

    public static List<Project> loadProjectsFromJSON() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(PROJECTS_FILE);
        Type projectListType = new TypeToken<List<Project>>(){}.getType();
        List<Project> projects = gson.fromJson(reader, projectListType);
        reader.close();
        return projects;
    }
}