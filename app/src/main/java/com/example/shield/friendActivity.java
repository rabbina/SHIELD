package com.example.shield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class friendActivity extends AppCompatActivity {
    Button mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        getSupportActionBar().setTitle("Friends");

        mapButton=findViewById(R.id.btn_frnd1);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Getting Friend's Location!", Toast.LENGTH_LONG); toast.show();
                Intent mapIntent = new Intent(friendActivity.this, MapsActivity.class);
                startActivity(mapIntent);
                //finish();
            }
        });
    }
}
