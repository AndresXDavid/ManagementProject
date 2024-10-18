package co.edu.uptc.project.persistence;

import co.edu.uptc.project.model.Project;
import co.edu.uptc.project.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONManager {
    private static final String USERS_FILE = "C:\\Users\\VICTUS\\Desktop\\ManagementProject\\co\\edu\\uptc\\project\\persistence\\users.json";
    private static final String PROJECTS_FILE = "projects.json";
    

    public static void saveUsersToJSON(List<User> users) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(USERS_FILE)) {
            gson.toJson(users, writer);
        }
    }

 
    public static List<User> loadUsersFromJSON() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(USERS_FILE)) {
            Type userListType = new TypeToken<List<User>>(){}.getType();
            return gson.fromJson(reader, userListType);
        } catch (IOException e) {
            return new ArrayList<>(); 
        }
    }

   
    public static void saveProjectsToJSON(List<Project> projects) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(PROJECTS_FILE)) {
            gson.toJson(projects, writer);
        }
    }

    public static List<Project> loadProjectsFromJSON() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(PROJECTS_FILE)) {
            Type projectListType = new TypeToken<List<Project>>(){}.getType();
            return gson.fromJson(reader, projectListType);
        } catch (IOException e) {
            return new ArrayList<>(); 
        }
    }
}
