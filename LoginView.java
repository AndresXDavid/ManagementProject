package co.uptc.edu.vista;

import co.uptc.edu.controller.UserManager;
import java.util.Scanner;

public class LoginView {
    private UserManager userManager;
    private Scanner scanner;

    public LoginView(UserManager userManager) {
        this.userManager = userManager;
        this.scanner = new Scanner(System.in);
    }

    // Mostrar el menú principal
    public void displayMenu() {
        while (true) {
            System.out.println("1. Registrar");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Registro de nuevo usuario
    private void registerUser() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        userManager.registerUser(username, password);
    }

    // Inicio de sesión de usuario
    private void loginUser() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        userManager.loginUser(username, password);
    }
}
