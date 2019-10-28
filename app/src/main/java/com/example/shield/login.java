package com.example.shield;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity implements View.OnClickListener{



    Button signupButton;
    Button loginButton;
    EditText email_in,password_in;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.login);

        email_in = (EditText)findViewById(R.id.email_in);
        password_in = (EditText)findViewById(R.id.password_in);

        firebaseAuth =FirebaseAuth.getInstance();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_in.getText().toString().trim();
                String password = password_in.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(login.this, "Please enter your email!", Toast.LENGTH_SHORT);
                    return;
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(login.this, "Please enter your password!", Toast.LENGTH_SHORT);
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            Toast.makeText(login.this, "log in Succesful!", Toast.LENGTH_SHORT);
                        }else {
                            Toast.makeText(login.this, "login  Failed!", Toast.LENGTH_SHORT);
                        }
                    }
                });



                Intent mapIntent = new Intent(login.this, Main.class);
                startActivity(mapIntent);
                finish();
            }
        });



        signupButton=findViewById(R.id.btn_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SiIntent = new Intent(login.this, signup.class);
                startActivity(SiIntent);
                //finish();
            }
        });



    }

    @Override
    public void onClick(View v) {

    }
}

