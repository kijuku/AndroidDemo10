package com.main.androiddemo9;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivityDelUsers extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_del_users);
        makeRadioButtons();
        context = MainActivityDelUsers.this;
    }


    public void makeRadioButtons(){
        RadioGroup rgDelUsers = findViewById(R.id.rgDelUsers);
        ArrayList<User> delUsers = UserStorage.getInstance().getUsers();
        int i = 0;

        RadioButton rb;
        for (User u: delUsers){
            rb = new RadioButton(this);
            System.out.println(u.getLastName() + ", " + u.getFirstName());
            rb.setText(u.getLastName() + ", " + u.getFirstName());
            rb.setId(i++);
            rgDelUsers.addView(rb);
        }
    }

    public void delUser(View view){
        RadioGroup rgDelUsers = findViewById(R.id.rgDelUsers);
        System.out.println("RADIO: " + rgDelUsers.getCheckedRadioButtonId());
        if (rgDelUsers.getCheckedRadioButtonId() != -1) {
            UserStorage.getInstance().removeUser(rgDelUsers.getCheckedRadioButtonId());
            UserStorage.getInstance().saveUserData(context);
            UserStorage.getInstance().printUserData();
            switchListUserMainActivity(view);
        } else {
            new AlertDialog.Builder(this).setTitle("Opiskelijan poisto:").setMessage("Et valinnut poistettavaa opiskelijaa!").setNeutralButton("Sulje", null).show();
        }
    }

    public void switchMainActivity(View view){
        Intent intent = new Intent(this, MainActivity0.class );

        startActivity(intent);
    }
    public void switchListUserMainActivity(View view){
        Intent intent = new Intent(this, MainActivityListUsers.class );

        startActivity(intent);
    }
}