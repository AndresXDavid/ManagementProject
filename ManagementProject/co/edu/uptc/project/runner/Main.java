package co.edu.uptc.project.runner;

import co.edu.uptc.project.model.Project;
import co.edu.uptc.project.model.Task;
import co.edu.uptc.project.model.User;
import co.edu.uptc.project.persistence.JSONManager;
import co.edu.uptc.project.runner.LoginService;
import co.edu.uptc.project.services.ProjectServices;
import co.edu.uptc.project.services.ServiceTask;
import co.edu.uptc.project.views.KanbanView;
import co.edu.uptc.project.services.ServiceUser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ServiceUser userService = new ServiceUser();
            List<User> users = JSONManager.loadUsersFromJSON(); // Cargar usuarios de JSON
            userService.getUsers().addAll(users);  // Agregar usuarios existentes al servicio

            boolean exit = false;

            // Menú para registrar o iniciar sesión
            User loggedInUser = null;
            while (loggedInUser == null) {
                System.out.println("1. Log In");
                System.out.println("2. Register");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Limpiar buffer

                switch (choice) {
                    case 1:
                        LoginService loginService = new LoginService();
                        loggedInUser = loginService.login();
                        if (loggedInUser == null) {
                            System.out.println("Login failed. Try again.");
                        }
                        break;

                    case 2:
                        System.out.println("Register a new user:");
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();
                        userService.registerUser(name, email);
                        JSONManager.saveUsersToJSON(userService.getUsers()); // Guardar nuevos usuarios
                        System.out.println("User registered successfully! You can now log in.");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            }

            if (loggedInUser == null) {
                System.out.println("Access denied. Exiting...");
                return;
            }

            // Menú principal para la gestión de proyectos
            ProjectServices projectServices = new ProjectServices();
            ServiceTask taskService = new ServiceTask();
            KanbanView kanbanView = new KanbanView();
            List<Project> projects = JSONManager.loadProjectsFromJSON();  
            projectServices.setProjects(projects);

            while (!exit) {
                System.out.println("\nProject Management Menu");
                System.out.println("1. Create Project");
                System.out.println("2. View Projects");
                System.out.println("3. Add Task to a Project");
                System.out.println("4. Edit Task Status");
                System.out.println("5. View Kanban Board");
                System.out.println("6. Logout");

                System.out.print("Choose an option: ");
                int choice = -1;

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    continue; // Volver al inicio del menú
                }

                switch (choice) {
                    case 1:
                        System.out.println("Create a new Project:");
                        System.out.print("Enter project title: ");
                        String projectTitle = scanner.nextLine();
                        System.out.print("Enter project description: ");
                        String projectDescription = scanner.nextLine();
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        String startDate = scanner.nextLine();
                        System.out.print("Enter end date (YYYY-MM-DD): ");
                        String endDate = scanner.nextLine();
                        projectServices.createProject(projectTitle, projectDescription, startDate, endDate);
                        JSONManager.saveProjectsToJSON(projectServices.getProjects()); 
                        System.out.println("Project created successfully!");
                        break;

                    case 2:
                        System.out.println("Viewing Projects:");
                        for (Project project : projectServices.getProjects()) {
                            System.out.println(project.getTitle() + ": " + project.getDescription());
                        }
                        break;

                    case 3:
                        System.out.println("Add a Task to a Project:");
                        System.out.print("Enter project title: ");
                        String projectTitleAdd = scanner.nextLine();
                        Project projectToAdd = projectServices.getProjectByTitle(projectTitleAdd);
                        if (projectToAdd != null) {
                            System.out.print("Task title: ");
                            String taskTitle = scanner.nextLine();
                            System.out.print("Task description: ");
                            String taskDesc = scanner.nextLine();
                            taskService.createTask(projectToAdd, taskTitle, taskDesc, "2024-10-17");  
                            JSONManager.saveProjectsToJSON(projectServices.getProjects()); 
                            System.out.println("Task added!");
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Edit Task Status:");
                        System.out.print("Enter project title: ");
                        String projectTitleEdit = scanner.nextLine();
                        Project projectToEdit = projectServices.getProjectByTitle(projectTitleEdit);
                        if (projectToEdit != null) {
                            System.out.print("Enter task title: ");
                            String taskTitleEdit = scanner.nextLine();
                            Task taskToEdit = taskService.getTaskByTitle(projectToEdit, taskTitleEdit);
                            if (taskToEdit != null) {
                                System.out.print("Enter new status (pending, in progress, completed): ");
                                String newStatus = scanner.nextLine();
                                taskService.editTask(taskToEdit, newStatus);
                                JSONManager.saveProjectsToJSON(projectServices.getProjects());  
                                System.out.println("Task status updated!");
                            } else {
                                System.out.println("Task not found.");
                            }
                        } else {
                            System.out.println("Project not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Displaying Kanban Board:");
                        kanbanView.showBoard(projectServices.getAllTasks());
                        break;

                    case 6:
                        System.out.println("Logging out...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("unexpected error: " + e.getMessage());
        }
    }
}

