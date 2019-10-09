package com.example.shield;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    Button mapButton,fbutton,Sbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mapButton=findViewById(R.id.button3);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Safe Zone Near You!", Toast.LENGTH_SHORT); toast.show();
                Intent mapIntent = new Intent(Main.this, MapsActivity.class);
                startActivity(mapIntent);
                //finish();
            }
        });
        fbutton=findViewById(R.id.button2);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fIntent = new Intent(Main.this, friendActivity.class);
                startActivity(fIntent);
                //finish();
            }
        });

        Sbutton=findViewById(R.id.button6);
        Sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SIntent = new Intent(Main.this, settings.class);
                startActivity(SIntent);
                //finish();
            }
        });

//        FloatingActionButton fb = findViewById(R.id.fab_menu);
//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //startActivity(new Intent(getActivity(), voicecommand.class));
//                Toast.makeText(Main.this, "This is my Toast message!", Toast.LENGTH_LONG).show();
//            }
//        });

    }
}

//code etar complete just login press korar por button wala page load koro uporer code er moto
// :)ok korte yhako ami dekhi!!