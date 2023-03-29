package com.main.androiddemo9;

import java.util.ArrayList;

public class User extends Exam {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String degreeProgram;

    //protected ArrayList<String> exam = new ArrayList<>();
    protected Exam exam;
    protected int imageId;

    public User(String firstName, String lastName, String email, String degreeProgram, Exam exam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.imageId = R.drawable.photo1;
        this.exam = exam;
    }
    public User(String firstName, String lastName, String email, String degreeProgram, int imageId, Exam exam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.imageId = imageId;
        this.exam = exam;
    }
    public User(String firstName, String lastName, String email, String degreeProgram, int imageId, String exam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.imageId = imageId;
        this.exam.addExam(exam);
    }
    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public void setDegreeProgram(String degreeProgram) {
        this.degreeProgram = degreeProgram;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", degreeProgram='" + degreeProgram + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
