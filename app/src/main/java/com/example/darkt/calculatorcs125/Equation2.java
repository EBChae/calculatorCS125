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
    private Kinematics kin2 = new Kinematics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation2);

        Button mainBtn = findViewById(R.id.backBtn2);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt2 = findViewById(R.id.graphBtn2);
        graphBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(Double.parseDouble(kin2.getTim()) < 0)) {
                    Intent startIntent = new Intent(Equation2.this, Graph1.class);
                    startIntent.putExtra("vi", kin2.getVi());
                    startIntent.putExtra("t", kin2.getTim());
                    startIntent.putExtra("a", kin2.getAcc());
                    startActivity(startIntent);
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
                    toast.makeText(Equation2.this, "Time can not be negative.", toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eqnCalc2Btn(View v) {
        String acceleration = ((EditText)findViewById(R.id.getA2)).getText().toString();
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial2)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal2)).getText().toString();
        String time = ((EditText)findViewById(R.id.getTime2)).getText().toString();

        String calculated = kin2.kinematics2(initialVelocity, finalVelocity, time, acceleration);

        TextView output = findViewById(R.id.answerFound2);
        output.setText(calculated);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0 , 0);
        toast.makeText(Equation2.this, kin2.getSuccessful(), toast.LENGTH_SHORT).show();
    }
}
