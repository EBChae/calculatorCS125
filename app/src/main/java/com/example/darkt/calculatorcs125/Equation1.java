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
    private Kinematics kin1 = new Kinematics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation1);

        Button mainBtn = findViewById(R.id.backBtn1);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        Button graphBt1 = findViewById(R.id.graphBtn1);
        graphBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(Double.parseDouble(kin1.getTim()) < 0)) {
                    Intent startIntent = new Intent(Equation1.this, Graph1.class);
                    startIntent.putExtra("vi", kin1.getVi());
                    startIntent.putExtra("t", kin1.getTim());
                    startIntent.putExtra("a", kin1.getAcc());
                    startActivity(startIntent);
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
                    toast.makeText(Equation1.this, "Time can not be negative.", toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void eqnCalc1Btn(View v) {
        String initialVelocity = ((EditText)findViewById(R.id.getvInitial)).getText().toString();
        String finalVelocity = ((EditText)findViewById(R.id.getvFinal)).getText().toString();
        String time = ((EditText)findViewById(R.id.getTime)).getText().toString();
        String displacement = ((EditText)findViewById(R.id.getX)).getText().toString();

        String answer = kin1.kinematics1(initialVelocity, finalVelocity, displacement, time);

        TextView output = findViewById(R.id.answerFound1);
        output.setText(answer);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.START, 0 , 0);
        toast.makeText(Equation1.this, kin1.getSuccessful(), toast.LENGTH_SHORT).show();
    }
}
