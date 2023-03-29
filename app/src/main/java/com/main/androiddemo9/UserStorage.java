package com.main.androiddemo9;

import java.util.ArrayList;

public class UserStorage extends User {
    private static ArrayList<User> users = new ArrayList<>();
    private static UserStorage userstorage = null;

    private UserStorage(){
        super();

    }

    private UserStorage(String firstName, String lastName, String email, String degreeProgram,Exam exam) {
        super(firstName, lastName, email, degreeProgram,exam);
    }

    // Singleton
    public static UserStorage getInstance(){
        if (userstorage == null){
            userstorage = new UserStorage();
        }
        return userstorage;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void removeUser(int id){
        if (!users.isEmpty()) {
            users.remove(id);
        }
    }

    public void addUser(User user){
        users.add(user);
    }

}
