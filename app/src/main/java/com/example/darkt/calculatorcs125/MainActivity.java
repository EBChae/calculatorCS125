package com.example.darkt.calculatorcs125;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button eq1 = (Button) findViewById(R.id.equation1Btn);
        eq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Equation1.class);
                startActivity(startIntent);
            }
        });
        Button eq2 = (Button) findViewById(R.id.equation2Btn);
        eq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Equation2.class);
                startActivity(startIntent);
            }
        });
        Button eq3 = (Button) findViewById(R.id.equation3Btn);
        eq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Equation3.class);
                startActivity(startIntent);
            }
        });
        Button eq4 = (Button) findViewById(R.id.equation4Btn);
        eq4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Equation4.class);
                startActivity(startIntent);
            }
        });
    }
 }