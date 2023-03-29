package com.main.androiddemo9;

import java.util.ArrayList;

public class Exam {
    protected ArrayList<String> exam = new ArrayList<>();

    public Exam(){

    }

    public Exam(ArrayList<String> exam) {
        this.exam = exam;
    }

    public ArrayList<String> getExam() {
        return exam;
    }

    public void setExam(ArrayList<String> exam) {
        this.exam = exam;
    }

    public void addExam(String newExam){
        this.exam.add(newExam);
    }

    public String toString(){
        String t = "Suoritetut tutkinnot:\n";
        for (String s: this.getExam()) {
            t += "-" + s + "\n";
        }

        return t;
    }
}
