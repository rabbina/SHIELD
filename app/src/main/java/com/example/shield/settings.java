package com.example.shield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class settings extends AppCompatActivity {
    Button logOutButton,addcbutton,vButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle("Settings");

        logOutButton=findViewById(R.id.logoutbutton);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Logging Out!", Toast.LENGTH_SHORT); toast.show();
                Intent intent = new Intent(settings.this, login.class);
                startActivity(intent);
                //finish();
            }
        });

        vButton=findViewById(R.id.vcbutton);
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Waiting for Command voice, Say Something!", Toast.LENGTH_LONG); toast.show();
                //Intent mapIntent = new Intent(settings.this, Main.class);
                //startActivity(mapIntent);
                //finish();
            }
        });


    }
}
