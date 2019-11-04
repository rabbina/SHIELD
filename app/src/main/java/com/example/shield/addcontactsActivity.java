package com.example.shield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addcontactsActivity extends AppCompatActivity {

    Button acButton;
    EditText tname1,tname2,tname3, tnum1,tnum2,tnum3;

    FirebaseFirestore firestore;
    CollectionReference Users,Friends;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontacts);

        acButton =findViewById(R.id.buttonconfirm);
        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth =FirebaseAuth.getInstance();
                firestore = FirebaseFirestore.getInstance();

                tname1 = (EditText)findViewById(R.id.name1);
                tname2 = (EditText)findViewById(R.id.name2);
                tname3 = (EditText)findViewById(R.id.name3);

                tnum1 = (EditText)findViewById(R.id.number1);
                tnum2 = (EditText)findViewById(R.id.number2);
                tnum3 = (EditText)findViewById(R.id.number3);


                String name1 = tname1.getText().toString().trim();
                String name2 = tname2.getText().toString().trim();
                String name3 = tname3.getText().toString().trim();
                String num1 = tnum1.getText().toString().trim();
                String num2 = tnum2.getText().toString().trim();
                String num3 = tnum3.getText().toString().trim();

                Users = firestore.collection(firebaseAuth.getCurrentUser().getUid());
                Friends = Users;
                Map<String, String> userData = new HashMap<>();
                userData.put("Contact 1 name", name1);
                userData.put("Contact 2 name", name2);
                userData.put("Contact 3 name", name1);
                userData.put("Contact 1 num", num1);
                userData.put("Contact 2 num", num2);
                userData.put("Contact 3 num", num3);
                Friends.add(userData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //progressDialog.dismiss();
                        //Toast.makeText(addcontactsActivity.this, "Added Succesfully!", Toast.LENGTH_SHORT);
                        //finish();
                    }
                });


                Toast toast = Toast.makeText(getApplicationContext(), "new contact added!", Toast.LENGTH_LONG); toast.show();
                Intent fIntent = new Intent(addcontactsActivity.this, friendActivity.class);
                startActivity(fIntent);
                finish();
            }
        });
    }
}
