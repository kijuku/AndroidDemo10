package com.main.androiddemo9;

import android.content.Context;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage extends User implements Serializable {
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

    //*************************************************
    // Lajittelu
    //*************************************************
    class SortByLastname implements Comparator<User>{

        @Override
        public int compare(User o1, User o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }

        @Override
        public Comparator<User> reversed() {
            return Comparator.super.reversed();
        }
    }

    class SortByFirstname implements Comparator<User>{

        @Override
        public int compare(User o1, User o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }

        @Override
        public Comparator<User> reversed() {
            return Comparator.super.reversed();
        }
    }

    class SortByLineOfStudy implements Comparator<User>{

        @Override
        public int compare(User o1, User o2) {
            return o1.getDegreeProgram().compareTo(o2.getDegreeProgram());
        }

        @Override
        public Comparator<User> reversed() {
            return Comparator.super.reversed();
        }
    }

    //*************************************************
    public void addUser(User user){
        users.add(user);
    }

    //*************************************************
    public void sortUserData(Values val){
        Comparator c;
        switch (val){
            case UPWARDS:
                break;
            case DOWNWARDS:
                break;
            case FIRSTNAME:
                c = Collections.reverseOrder(new SortByFirstname());
                Collections.sort(users,Collections.reverseOrder(c));
                break;
            case LASTNAME:
                c = Collections.reverseOrder(new SortByLastname());
                Collections.sort(users,Collections.reverseOrder(c));
            break;
            case LINEOFSTUDY:
                c = Collections.reverseOrder(new SortByLineOfStudy());
                Collections.sort(users,Collections.reverseOrder(c));
            break;
            default:
                break;
        }

    }
    public void loadUserData(Context context){
        try {
            ObjectInputStream dataReader = new ObjectInputStream(context.openFileInput("userdata.dat"));
            users = (ArrayList<User>) dataReader.readObject();
            //userstorage = (UserStorage) dataReader.readObject();

            dataReader.close();
            UserStorage.getInstance().sortUserData(Values.LASTNAME);
            printUserData();
            System.out.println("UserDatan lukeminen onnistui!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printUserData(){
        System.out.println("UserStoragen sisältö:");
        System.out.println("=====================");

        for (User u : getUsers()) {
            System.out.println(u);
        }
        System.out.println("");
    }

    public void saveUserData(Context context ){
        try {
            ObjectOutputStream dataWriter = new ObjectOutputStream(context.openFileOutput("userdata.dat", Context.MODE_PRIVATE));
            dataWriter.writeObject(users);
            dataWriter.close();
            System.out.println("UserDatan tallentaminen onnistui!");
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("UserDatan tallentaminen epäonnistui!");
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

}
