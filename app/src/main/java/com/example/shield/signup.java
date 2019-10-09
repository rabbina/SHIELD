package com.example.shield;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    Button regis,ggle;
/*
    private EditText editTextname;
    private EditText editTextemail;
    private EditText editTextpass;
    private EditText editTextcpass;
    private TextView textViewname;
    private TextView textViewemail;
    private TextView textViewpass;
    private TextView textViewcpass;



    private FirebaseAuth mAuth;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SignUp Form");


/*
        mAuth=FirebaseAuth.getInstance();
        editTextname= (EditText) findViewById(R.id.editTextname);
        editTextemail= (EditText) findViewById(R.id.editTextemail);
        editTextpass= (EditText) findViewById(R.id.editTextpass);
        editTextcpass= (EditText) findViewById(R.id.editTextcpass);
        textViewname=(TextView) findViewById(R.id.textViewname);
        textViewemail=(TextView) findViewById(R.id.textViewemail);
        textViewpass=(TextView) findViewById(R.id.textViewpass);
        textViewcpass=(TextView) findViewById(R.id.textViewcpass);*/

        regis= findViewById(R.id.btn_regis);
        regis.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent mapIntent = new Intent(signup.this, Main.class);
            startActivity(mapIntent);
            finish();
        }
    });

        ggle=findViewById(R.id.btn_ggle);

        ggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mapIntent = new Intent(signup.this, Main.class);
                startActivity(mapIntent);
                finish();
            }
        });

    }
    /*

    private void registerUser() {

        String name = editTextname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String pass = editTextpass.getText().toString().trim();
        String cpass = editTextcpass.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {

            Toast.makeText(this,"Please enter Full Name",Toast.LENGTH_SHORT).show();
            //return stops function execution further
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,"Please enter your Email",Toast.LENGTH_SHORT).show();
            //return stops function execution further
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            //return stops function execution further
            return;
        }
        if (TextUtils.isEmpty(cpass)) {
            Toast.makeText(this,"Please confirm Password",Toast.LENGTH_SHORT).show();
            //return stops function execution further
            return;
        }

        mAuth.createUserWithEmailAndPassword(name,email,pass,cpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(signup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {




        if(v==regis){
            registerUser();
        }

        if(v==ggle){
            registerUser();
        }

        if(v==textViewname){

        }
        if(v==textViewemail){

        }
        if(v==textViewpass){

        }
        if(v==textViewcpass){

        }


    }*/
}

