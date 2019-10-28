package com.example.shield;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    Button regis,ggle;

    FirebaseFirestore firestore;
    CollectionReference Users;
    FirebaseAuth firebaseauth;
    EditText editTextname,editTextemail,editTextpass,editTextcpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SignUp Form");

        editTextname= (EditText) findViewById(R.id.editTextname);
        editTextemail= (EditText) findViewById(R.id.editTextemail);
        editTextpass= (EditText) findViewById(R.id.editTextpass);
        editTextcpass= (EditText) findViewById(R.id.editTextcpass);

        //regis =(Button) findViewById(R.id.btn_regis);

        firebaseauth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        regis= findViewById(R.id.btn_regis);

        regis.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            final String name = editTextname.getText().toString().trim();
            String email = editTextemail.getText().toString().trim();
            String password = editTextpass.getText().toString().trim();
            String cpassword = editTextcpass.getText().toString().trim();
/*
            if (TextUtils.isEmpty(name)){
                Toast.makeText(signup.this, "Please enter your name!", Toast.LENGTH_SHORT);
                return;
            }else if (TextUtils.isEmpty(email)){
                Toast.makeText(signup.this, "Please enter your email!", Toast.LENGTH_SHORT);
                return;
            }else if (TextUtils.isEmpty(password)){
                Toast.makeText(signup.this, "Please enter your password!", Toast.LENGTH_SHORT);
                return;
            }else if (TextUtils.isEmpty(cpassword)){
                Toast.makeText(signup.this, "Please confirm  your password!", Toast.LENGTH_SHORT);
                return;
            }
*/
            if(password.equals(cpassword)){
                //final ProgressDialog progressDialog =new ProgressDialog(signup.this);
                //progressDialog.setMessage("Registering and saving data...");
                //progressDialog.setCancelable(false);
                //progressDialog.setCanceledOnTouchOutside(false);
                //progressDialog.show();
            firebaseauth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    FirebaseUser user = authResult.getUser();
                    Users = firestore.collection(user.getUid());
                    Map<String, String> userData = new HashMap<>();
                    userData.put("name", name);
                    Users.add(userData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            //progressDialog.dismiss();
                            Toast.makeText(signup.this, "Registration Succesful!", Toast.LENGTH_SHORT);
                            finish();
                        }
                    });
                }
            });
        }

          /*  if(password.equals(cpassword)){
                firebaseauth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            Toast.makeText(signup.this, "Registration Succesful!", Toast.LENGTH_SHORT);
                        }else {
                            Toast.makeText(signup.this, "Registration Failed!", Toast.LENGTH_SHORT);
                        }
                    }
                });
            }
            */

        }
    });

        ggle=findViewById(R.id.btn_ggle);

        ggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main.class));
                Toast.makeText(signup.this, "Registration Succesful!", Toast.LENGTH_SHORT);
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

