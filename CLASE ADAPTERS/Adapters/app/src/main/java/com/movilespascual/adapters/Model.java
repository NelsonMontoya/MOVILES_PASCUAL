package com.movilespascual.adapters;

// Clase publica del modelo
public class Model {
    private  String name, lastName, user, password;
    private int userId;

    //constructor
    public Model(String name, String lastName, String user, String password, int userId) {
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.userId = userId;
    }

    
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
