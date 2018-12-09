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

public class Equation2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation2);

        Button mainBtn = (Button) findViewById(R.id.backBtn2);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt2 = (Button) findViewById(R.id.graphBtn2);
        graphBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Graph2.class);
                startActivity(startIntent);
            }
        });
    }
    public void eqnCalc2Btn(View v) {
        String acceleration = ((EditText)findViewById(R.id.getA2)).getText().toString();
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial2)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal2)).getText().toString();
        String time = ((EditText)findViewById(R.id.getTime2)).getText().toString();

        Button calculate = (Button) v;
        String calculated = kinematics(initialVelocity, finalVelocity, time, acceleration);
        TextView output = (TextView) findViewById(R.id.answerFound2);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0 , 0);
        toast.makeText(Equation2.this, "Done", toast.LENGTH_SHORT).show();
    }
    public String kinematics(String vi, String vf, String t, String a) {
        try {
            if (vf.equals("")) {
                double convVI = Double.parseDouble(vi);
                double convA = Double.parseDouble(a);
                double convT = Double.parseDouble(t);
                double convVF = convVI + convA * convT;
                return String.format("%.3f", convVF);

            } else if (vi.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convA = Double.parseDouble(a);
                double convT = Double.parseDouble(t);
                double convVI = convVF - convA * convT;
                return String.format("%.3f", convVI);

            } else if (a.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convVI = Double.parseDouble(vi);
                double convT = Double.parseDouble(t);
                double convA = (convVF - convVI) / convT ;
                return String.format("%.3f", convA);

            } else if (t.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convVI = Double.parseDouble(vi);
                double convA = Double.parseDouble(a);
                double convT = (convVF - convVI) / convA;
                return String.format("%.3f", convT);
            } else {
                return "Only one variable must be empty.";
            }
        } catch (Exception e) {
            return "Invalid Calculation";
        }
    }
}
