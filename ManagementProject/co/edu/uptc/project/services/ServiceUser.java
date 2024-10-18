package co.edu.uptc.project.services;

import co.edu.uptc.project.model.User;

import java.util.ArrayList;
import java.util.List;

public class ServiceUser {

    private List<User> users;

    public ServiceUser() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}