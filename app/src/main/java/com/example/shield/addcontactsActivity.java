package com.example.shield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addcontactsActivity extends AppCompatActivity {

    Button acButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontacts);

        acButton =findViewById(R.id.buttonconfirm);
        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "new contact added!", Toast.LENGTH_LONG); toast.show();
                Intent fIntent = new Intent(addcontactsActivity.this, friendActivity.class);
                startActivity(fIntent);
                //finish();
            }
        });
    }
}
