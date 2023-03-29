package com.main.androiddemo9;

import static com.main.androiddemo9.R.layout.listuser_adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;


public class StudentListAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();
    @NonNull
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new StudentViewHolder(LayoutInflater.from(context).inflate(listuser_adapter,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(users.get(i).getFirstName() + " " + users.get(i).getLastName());

        studentViewHolder.studentName.setText(sb.toString());
        studentViewHolder.studentLinOfStudy.setText(users.get(i).getDegreeProgram());
        //System.out.println(users.get(i).getEmail());
        studentViewHolder.studentEmail.setText(String.valueOf(users.get(i).getEmail()));
        studentViewHolder.studentExam.setText(String.valueOf(users.get(i).toString()));
        studentViewHolder.imageView.setImageResource(users.get(i).getImageId());
    }
    public StudentListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }





    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
