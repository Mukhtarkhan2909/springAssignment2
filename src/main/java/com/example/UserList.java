package com.example;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<Users> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public void addUser(Users user) {
        users.add(user);
    }
    public void removeUser(Users user) {
        users.remove(user);
    }
    public List<Users> getUsers() {
        return users;
    }
}
