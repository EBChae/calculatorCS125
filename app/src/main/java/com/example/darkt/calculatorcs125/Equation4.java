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

public class Equation4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation4);

        Button mainBtn = findViewById(R.id.backBtn4);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt4 = findViewById(R.id.graphBtn4);
        graphBt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Graph4.class);
                startActivity(startIntent);
            }
        });
    }
    public void eqnCalc4Btn(View v) {
        String displacement = ((EditText)findViewById(R.id.getX4)).getText().toString();
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial4)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal4)).getText().toString();
        String acceleration = ((EditText)findViewById(R.id.getA4)).getText().toString();

        String calculated = kinematics(displacement, initialVelocity, finalVelocity, acceleration);
        TextView output = findViewById(R.id.answerFound4);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0 , 0);
        toast.makeText(Equation4.this, "Done", toast.LENGTH_SHORT).show();
    }
    public String kinematics(String d, String vi, String vf, String a) {
        try {
            if (vf.equals("")) {
                double convD = Double.parseDouble(d);
                double convA = Double.parseDouble(a);
                double convVI = Double.parseDouble(vi);
                double convVF = Math.sqrt(convVI * convVI + 2 * convA * convD);
                return String.format("%.3f", convVF);

            } else if (vi.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convA = Double.parseDouble(a);
                double convD = Double.parseDouble(d);
                double convVI = Math.sqrt(2 * convA * convD) - convVF * convVF;
                return String.format("%.3f", convVI);

            } else if (d.equals("")) {
                double convVI = Double.parseDouble(vi);
                double convVF = Double.parseDouble(vf);
                double convA = Double.parseDouble(a);
                double convD = Math.pow(convVF, 2) - Math.pow(convVI, 2) / (2 * convA);
                return String.format("%.3f", convD);

            } else if (a.equals("")) {
                double convD = Double.parseDouble(d);
                double convVI = Double.parseDouble(vi);
                double convVF = Double.parseDouble(vf);
                double convA = (Math.pow(convVF, 2) - Math.pow(convVI, 2)) / (2 * convD);
                return String.format("%.3f", convA);
            } else {
                return "Only one variable must be empty.";
            }
        } catch (Exception e) {
            return "Invalid Calculation";
        }
    }
}
