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

        Button graphBtn = (Button) findViewById(R.id.graphButton);
        graphBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Graph.class);
                startActivity(startIntent);
            }
        });
    }
    public void buttonOnClick(View v) {
        Button calculate = (Button) v;
        EditText input = (EditText)findViewById(R.id.inputBox1);
        String calculated = gForce(input.getText().toString());
        TextView output = (TextView) findViewById(R.id.outputBox1);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0 , 0);
        toast.makeText(MainActivity.this, "calculated", toast.LENGTH_SHORT).show();
    }
    public String gForce(String mass) {
        double convMass = Double.parseDouble(mass);
        double result = convMass * 9.8;
        return String.format("%.3f", result);
    }
}