package com.main.androiddemo9;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    private TextView tv_firstName;
    private TextView tv_lastName;
    private TextView tv_email;
    private ImageView imageView;
    private RadioGroup rg_LineOfStydy;

    private Spinner spinner;

    private UserStorage users;

    private String[] photos = { "Valitse kuva...","photo1", "photo2", "photo3", "photo4", "photo5" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Luodaan käyttäjäsäilö.
        users = UserStorage.getInstance();

        spinner = (Spinner) findViewById(R.id.imageSpinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,photos);

        aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aadapter);

        imageView = findViewById(R.id.imageViewSelected);
        tv_firstName = findViewById(R.id.viewFirstName);
        tv_lastName = findViewById(R.id.viewLastName);
        tv_email = findViewById(R.id.viewEmail);
        rg_LineOfStydy= findViewById(R.id.radioGroup);

    }

    public void addNewUserToStorage(View view){
        StringBuilder sb = new StringBuilder();
        String fName, lName, email;
        String lineOfStudy = "";


        if (!tv_firstName.getText().toString().isEmpty() && !tv_lastName.getText().toString().isEmpty() && !tv_email.getText().toString().isEmpty()){
            fName = tv_firstName.getText().toString();
            lName = tv_lastName.getText().toString();
            email = tv_email.getText().toString();
            switch (rg_LineOfStydy.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    lineOfStudy += "Tietotekniikka";
                    break;
                case R.id.radioButton2:
                    lineOfStudy += "Tuotantotalous";
                    break;
                case R.id.radioButton3:
                    lineOfStudy += "Laskennallinen tekniikka";
                    break;
                case R.id.radioButton4:
                    lineOfStudy += "Sähkötekniikka";
                    break;
            }
            //spinnerId = spinner.getId();
            String spinnerText = spinner.getSelectedItem().toString();
            System.out.println("Kuvan nimi: " + spinnerText);
            imageView.setImageResource(selectImageId(spinnerText));
            Exam exam = new Exam();
            // Lisätään käyttäjä
            User newUser = new User(fName, lName,email,lineOfStudy,exam);

            // Asetetaan kuva newUserille
            newUser.setImageId(selectImageId(spinnerText));

            // Lisätään käyttäjä newUser Arraylistiin
            users.addUser(newUser);

            System.out.println("Lisätty käyttäjä:");
            System.out.println(newUser);
            System.out.println("UserStoragen käyttäjät:");
            System.out.println("=======================");
            for (User u : users.getUsers()){
                System.out.println(u.toString());
            }

        }

    }
    public int selectImageId(String spinnerText){
        int ret = 0;
        switch (spinnerText){
            case "photo1":
                ret = R.drawable.photo1;
                break;
            case "photo2":
                ret = R.drawable.photo2;
                break;
            case "photo3":
                ret = R.drawable.photo3;
                break;
            case "photo4":
                ret = R.drawable.photo4;
                break;
            case "photo5":
                ret = R.drawable.photo5;
                break;
            default:
                break;
        }
        return ret;
    }
    public void switchMainActivity(View view){
        Intent intent = new Intent(this, MainActivity0.class );
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerText = spinner.getSelectedItem().toString();
        System.out.println("Päivitettävän kuvan nimi: " + spinnerText);
        imageView.setImageResource(selectImageId(spinnerText));

        // new AlertDialog.Builder(this).setTitle("Kuva valinta:").setMessage("Et valinnut kuvaa!").setNeutralButton("Close", null).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}