package com.example.fourinarow1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 101;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name); // give a value to the name user enters

        findViewById(R.id.start).setOnClickListener(this::nameCheck);
    }

    public void nameCheck(View view) {
        if (name.getText().toString().equals("")) {
            Toast.makeText(this,"Enter username above",Toast.LENGTH_LONG).show();
        }
        else {
            Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
            startIntent.putExtra("input", name.getText().toString());
            startActivity(startIntent);
        }
    }

}