package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    EditText name,username, password;
    Button login;
    String  name1 = "Ranjeet singh";
    String user = "student1";
    String pass = "123456";


    public static String studentName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        name=findViewById(R.id.name1);
        username = findViewById(R.id.user1);
        password = findViewById(R.id.pass1);
        login = findViewById(R.id.btn);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(username.getText().toString().isEmpty() && password.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Invalid username or pssword",Toast.LENGTH_LONG).show();
        }
        else
        {
            //navigate to the MainActivity
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }


    }
}