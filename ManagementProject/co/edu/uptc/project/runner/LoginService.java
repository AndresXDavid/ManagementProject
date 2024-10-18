package co.edu.uptc.project.runner;

import co.edu.uptc.project.model.User;
import co.edu.uptc.project.persistence.JSONManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoginService {

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();  
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();   

        try {
           
            List<User> users = JSONManager.loadUsersFromJSON();

            System.out.println("Usuarios cargados: " + users);

         
            for (User user : users) {
                System.out.println("Comparando con usuario: " + user); 
                if (user.getEmail().equals(email) && user.getName().equals(name)) {
                    System.out.println("Login successful. Welcome " + user.getName() + "!");
                    return user;  // Retornamos el usuario logueado
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

       
        System.out.println("Login failed. User not found.");
        return null;
    }
}
