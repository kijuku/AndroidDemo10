package com.main.androiddemo9;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainActivity0 extends AppCompatActivity  {
    private UserStorage users;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        // Luodaan käyttäjäsäilö.
        users = UserStorage.getInstance();
        context = MainActivity0.this;

        users.loadUserData(context);
        //generateUsers(20);

        UserStorage.getInstance().printUserData();
        //Toast.makeText(context, context.getFilesDir().toString(), Toast.LENGTH_SHORT).show();

    }
    public void generateUsers(int amount){
        if (amount < 1 ) {
            amount = 5;
        }
        for (int i = 0; i < amount; i++) {
            String sbname = new String("Kimmo" + i);
            String sbemail = new String("Kimmo" + i + ".Kulmala@gmail.com");

            User user = new User(sbname, "Kulmala", sbemail, "Tietotekniikka",null);
            users.addUser(user);
        }

        UserStorage.getInstance().printUserData();
    }

    public void switchAddUserActivity(View view){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }
    public void switchListUserActivity(View view){
        Intent intent = new Intent(this, MainActivityListUsers.class );
        startActivity(intent);
    }

    public void switchImageAddActivity(View view){
        Intent intent = new Intent(this, MainActivity_spinner.class );
        startActivity(intent);
    }

    public void switchDeleteUserActivity(View view){
        Intent intent = new Intent(this, MainActivityDelUsers.class );
        startActivity(intent);
    }

    public void saveUserData(View view){
      UserStorage.getInstance().saveUserData(context);
      UserStorage.getInstance().printUserData();
    }

    public void loadUserData(View view){
       UserStorage.getInstance().loadUserData(context);
        UserStorage.getInstance().printUserData();
    }

}