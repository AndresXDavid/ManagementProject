package co.uptc.edu.main;

import co.uptc.edu.controller.UserManager;
import co.uptc.edu.vista.LoginView;

public class App {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        LoginView loginView = new LoginView(userManager);

        // Mostrar el menú de inicio de sesión y registro
        loginView.displayMenu();
    }
}
