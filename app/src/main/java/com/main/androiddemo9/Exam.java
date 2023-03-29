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
    public String getExam(int position) {
        return exam.get(position);
    }

    public void setExam(ArrayList<String> exam) {
        this.exam = exam;
    }

    public void addExam(String newExam){
        this.exam.add(newExam);
    }

    public String listExam(){
        String t = "";
        for (int i = 0; i < exam.size(); i++ ){
            t += "-" + exam.get(i) + "\n";
        }
        return t;
    }
    public String toString(int position){
        return exam.get(position);
    }
}
