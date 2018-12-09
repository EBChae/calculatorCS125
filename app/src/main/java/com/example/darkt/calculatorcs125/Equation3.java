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
    private Kinematics kin3 = new Kinematics();
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
                if (!(Double.parseDouble(kin3.getTim()) < 0)) {
                    Intent startIntent = new Intent(Equation3.this, Graph1.class);
                    startIntent.putExtra("vi", kin3.getVi());
                    startIntent.putExtra("t", kin3.getTim());
                    startIntent.putExtra("a", kin3.getAcc());
                    startActivity(startIntent);
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
                    toast.makeText(Equation3.this, "Time can not be negative.", toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eqnCalc3Btn(View v) {
        String displacement = ((EditText) findViewById(R.id.getX3)).getText().toString();
        String initialVelocity = ((EditText) findViewById(R.id.getvInitial3)).getText().toString();
        String acceleration = ((EditText) findViewById(R.id.getA3)).getText().toString();
        String time = ((EditText) findViewById(R.id.getTime3)).getText().toString();

        String calculated = kin3.kinematics3(initialVelocity, displacement, time, acceleration);

        TextView output = findViewById(R.id.answerFound3);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
        toast.makeText(Equation3.this, kin3.getSuccessful(), toast.LENGTH_SHORT).show();
    }
}
