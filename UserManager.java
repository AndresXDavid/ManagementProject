package co.uptc.edu.controller;

import co.uptc.edu.model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String USER_FILE = "C:\\Users\\VICTUS\\Desktop\\Sistema De Gestion De Proyectos\\Sistema De Gestion De Proyectos\\src\\co\\uptc\\edu\\persistence\\users.json";
    private List<User> users;

    public UserManager() {
        users = loadUsers();
    }

    // Cargar usuarios desde el archivo JSON
    private List<User> loadUsers() {
        List<User> userList = new ArrayList<>();
        File file = new File(USER_FILE);
        
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
                // Convertir el texto JSON en lista de usuarios
                userList = parseJsonToUsers(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return userList;
    }

    // Guardar usuarios en el archivo JSON
    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            String json = usersToJson();
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Registrar un nuevo usuario
    public void registerUser(String username, String password) {
        if (getUserByUsername(username) == null) {
            User newUser = new User(username, password);
            users.add(newUser);
            saveUsers();
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("El nombre de usuario ya existe.");
        }
    }

    // Iniciar sesión
    public boolean loginUser(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Inicio de sesión exitoso.");
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            return false;
        }
    }

    // Buscar un usuario por su nombre
    private User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Convertir lista de usuarios a JSON (de forma manual)
    private String usersToJson() {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            json.append("{");
            json.append("\"username\":\"").append(user.getUsername()).append("\",");
            json.append("\"password\":\"").append(user.getPassword()).append("\"");
            json.append("}");
            if (i < users.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    // Convertir JSON en lista de usuarios (de forma manual)
    private List<User> parseJsonToUsers(String json) {
        List<User> userList = new ArrayList<>();
        json = json.trim();

        if (json.startsWith("[") && json.endsWith("]")) {
            String[] userArray = json.substring(1, json.length() - 1).split("\\},\\{");
            for (String userStr : userArray) {
                userStr = userStr.replace("{", "").replace("}", "");
                String[] fields = userStr.split(",");
                String username = fields[0].split(":")[1].replace("\"", "");
                String password = fields[1].split(":")[1].replace("\"", "");
                userList.add(new User(username, password));
            }
        }

        return userList;
    }
}
