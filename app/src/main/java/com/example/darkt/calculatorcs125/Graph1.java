package com.example.darkt.calculatorcs125;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graph1 extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation1graph);

        Intent intent = getIntent();
        double vi, vf, t, d, a;

        vi = Double.valueOf(intent.getStringExtra("vi"));
        vf = Double.valueOf(intent.getStringExtra("vf"));
        t = Double.valueOf(intent.getStringExtra("t"));
        d = Double.valueOf(intent.getStringExtra("d"));
        a = (vf - vi) / t;
        double max = t;

        double x = 0;
        double y;
        GraphView graph = (GraphView) findViewById(R.id.graph1);
        series = new LineGraphSeries<DataPoint>();
        graph.getViewport().setXAxisBoundsManual(true);

        for (int i = 0; i < t * 100; i++) {
            x += 0.01;
            y = vi * x + 0.5 * a * x * x;
            series.appendData(new DataPoint(x, y), true, (int)t * 100);
        }
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(max);
        graph.addSeries(series);
        Button mainBtn = (Button) findViewById(R.id.MainButton1);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Equation1.class);
                startActivity(startIntent);
            }
        });
    }
}
