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

public class Equation3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation3);

        Button mainBtn = findViewById(R.id.backBtn3);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt3 = findViewById(R.id.graphBtn3);
        graphBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Graph3.class);
                startActivity(startIntent);
            }
        });
    }
    public void eqnCalc3Btn(View v) {
        String displacement = ((EditText)findViewById(R.id.getX3)).getText().toString();
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial3)).getText().toString();
        String acceleration = ((EditText)findViewById(R.id.getA3)).getText().toString();
        String time = ((EditText)findViewById(R.id.getTime3)).getText().toString();

        String calculated = kinematics(displacement, initialVelocity, acceleration, time);
        TextView output = findViewById(R.id.answerFound3);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0 , 0);
        toast.makeText(Equation3.this, "Done", toast.LENGTH_SHORT).show();
    }
    public String kinematics(String d, String vi, String a, String t) {
        try {
            if (vi.equals("")) {
                double convD = Double.parseDouble(d);
                double convA = Double.parseDouble(a);
                double convT = Double.parseDouble(t);
                double convVI = (convD - 0.5 * convA * Math.pow(convT, 2)) / convT;
                return String.format("%.3f", convVI);

            } else if (d.equals("")) {
                double convVI = Double.parseDouble(vi);
                double convA = Double.parseDouble(a);
                double convT = Double.parseDouble(t);
                double convD = 0.5 * convA * Math.pow(convT, 2) + convVI * convT;
                return String.format("%.3f", convD);

            } else if (a.equals("")) {
                double convD = Double.parseDouble(d);
                double convVI = Double.parseDouble(vi);
                double convT = Double.parseDouble(t);
                double convA = 2 * (convD - convVI * convT) / Math.pow(convT, 2);
                return String.format("%.3f", convA);

            } else if (t.equals("")) {
                double convD = Double.parseDouble(d);
                double convVI = Double.parseDouble(vi);
                double convA = Double.parseDouble(a);
                double convT;
                if ((-1 * convVI + Math.sqrt(convVI * convVI + 2 * convA * convD)) / convA > 0) {
                    convT = -1 * convVI + Math.sqrt(convVI * convVI + 2 * convA * convD);
                } else {
                    convT = -1 * convVI - Math.sqrt(convVI * convVI + 2 * convA * convD) / convA;
                }
                return String.format("%.3f", convT);
            } else {
                return "Only one variable must be empty.";
            }
        } catch (Exception e) {
            return "Invalid Calculation";
        }
    }
}
