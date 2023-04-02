package com.main.androiddemo9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityListUsers extends AppCompatActivity {
    private UserStorage userStorage;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_users);
        userStorage = UserStorage.getInstance();
        recyclerView = findViewById(R.id.recyclerListStudent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentListAdapter(getApplicationContext(),userStorage.getUsers()) );

    }

    public void switchImageAddActivity(View view){
        Intent intent = new Intent(this, MainActivity_spinner.class );
        startActivity(intent);
    }
    public void switchMainActivity(View view){
        Intent intent = new Intent(this, MainActivity0.class );
        startActivity(intent);
    }

    public void sortUserDataByLastName(View view){
        userStorage.sortUserData(Values.LASTNAME);
        recyclerView.setAdapter(new StudentListAdapter(getApplicationContext(),userStorage.getUsers()));
    }
    public void sortUserDataByFirstName(View view){
        userStorage.sortUserData(Values.FIRSTNAME);
        recyclerView.setAdapter(new StudentListAdapter(getApplicationContext(),userStorage.getUsers()));
    }
    public void sortUserDataByExam(View view){
        userStorage.sortUserData(Values.LINEOFSTUDY);
        recyclerView.setAdapter(new StudentListAdapter(getApplicationContext(),userStorage.getUsers()));
    }
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + userStorage.getUsers().get(position).getLastName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}