package com.example.darkt.calculatorcs125;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
