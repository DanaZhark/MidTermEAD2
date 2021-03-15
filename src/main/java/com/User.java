package com;

public class User {

    private String userName;
    private String password;
    private double balance;
    private boolean online;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.balance = 0.0;
        this.online = false;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
