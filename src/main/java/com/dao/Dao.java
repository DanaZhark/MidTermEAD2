package com.dao;

import com.User;

import java.util.ArrayList;


public class Dao {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<User> liveUsers = new ArrayList<User>();
    public String authenticateUser(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();


        users.add(new User("admin", "123"));
        users.add(new User("editor", "123"));
        users.add(new User("user", "123"));

        for (User u : users) {
            if (u.getUserName().equals(userName) && userName.equals("admin") && u.getPassword().equals(password)) {
                u.setOnline(true);
                return "Admin_Role";
            }
            if (u.getUserName().equals(userName) && userName.equals("editor") && u.getPassword().equals(password)) {
                u.setOnline(true);
                return "Editor_Role";
            }
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                u.setOnline(true);
                return "User_Role";
            }
        }
        return "Invalid user credentials";
    }

    public ArrayList<User> getAllUsers() {
        //this method should retrieve the data for all users
        return users;
    }
}

