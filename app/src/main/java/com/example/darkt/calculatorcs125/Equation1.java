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

public class Equation1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation1);

        Button mainBtn = (Button) findViewById(R.id.backBtn1);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt1 = (Button) findViewById(R.id.graphBtn1);
        graphBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Graph1.class);
                startActivity(startIntent);
            }
        });
    }
    public void eqnCalc1Btn(View v) {
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal)).getText().toString();
        String time = ((EditText)findViewById(R.id.getTime)).getText().toString();
        String displacement = ((EditText)findViewById(R.id.getX)).getText().toString();

        Button calculate = (Button) v;
        String calculated = kinematics(initialVelocity, finalVelocity, time, displacement);
        TextView output = (TextView) findViewById(R.id.answerFound1);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0 , 0);
        toast.makeText(Equation1.this, "Done", toast.LENGTH_SHORT).show();
    }
    public String kinematics(String vi, String vf, String t, String d) {
        try {
            if (vf.equals("")) {
                double convVI = Double.parseDouble(vi);
                double convD = Double.parseDouble(d);
                double convT = Double.parseDouble(t);
                double convVF = 2 * convD / convT - convVI;
                return String.format("%.3f", convVF);

            } else if (vi.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convD = Double.parseDouble(d);
                double convT = Double.parseDouble(t);
                double convVI = 2 * convD / convT - convVF;
                return String.format("%.3f", convVI);

            } else if (d.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convVI = Double.parseDouble(vi);
                double convT = Double.parseDouble(t);
                double convD = (convVI + convVF) / 2 * convT;
                return String.format("%.3f", convD);

            } else if (t.equals("")) {
                double convVF = Double.parseDouble(vf);
                double convVI = Double.parseDouble(vi);
                double convD = Double.parseDouble(d);
                double convT = 2 * convD / (convVI + convVF);
                return String.format("%.3f", convT);
            } else {
                return "Only one variable must be empty.";
            }
        } catch (Exception e) {
            return "Invalid Calculation";
        }
    }
}
