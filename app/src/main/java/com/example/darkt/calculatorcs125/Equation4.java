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
    private Kinematics kin4 = new Kinematics();
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
                if (!(Double.parseDouble(kin4.getTim()) < 0)) {
                    Intent startIntent = new Intent(Equation4.this, Graph1.class);
                    startIntent.putExtra("vi", kin4.getVi());
                    startIntent.putExtra("t", kin4.getTim());
                    startIntent.putExtra("a", kin4.getAcc());
                    startActivity(startIntent);
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
                    toast.makeText(Equation4.this, "Time can not be negative.", toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eqnCalc4Btn(View v) {
        String displacement = ((EditText)findViewById(R.id.getX4)).getText().toString();
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial4)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal4)).getText().toString();
        String acceleration = ((EditText)findViewById(R.id.getA4)).getText().toString();

        String calculated = kin4.kinematics4(initialVelocity, finalVelocity, displacement, acceleration);

        TextView output = findViewById(R.id.answerFound4);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0 , 0);
        toast.makeText(Equation4.this, kin4.getSuccessful(), toast.LENGTH_SHORT).show();
    }
}
