package com.example.androidscrolldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.androidscrolldemo.widget.LineChartView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineChatActivity extends Activity {
    //x轴坐标对应的数据
    private List<String> xValue = new ArrayList<>();
    //y轴坐标对应的数据
    private List<Integer> yValue = new ArrayList<>();
    //折线对应的数据
    private Map<String, Integer> value = new HashMap<>();
    private LineChartView chartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chat);
        chartView = (LineChartView) findViewById(R.id.chartview);
        setMoth();
        findViewById(R.id.moth_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoth();
            }
        });

        findViewById(R.id.day_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xValue.clear();
                value.clear();
                yValue.clear();
                int dayInt = 0;
                for (int i = 0; i < 7; i++) {
                    dayInt = i+1;
                    xValue.add("星期"+(dayInt==1?"一":dayInt==2?"二":dayInt==3?"三":dayInt==4?"四":dayInt==5?"五":dayInt==6?"六":"日") );
                    value.put(xValue.get(i), (int) (Math.random() * 181 + 60));//60--240
                }

                for (int i = 0; i < 6; i++) {
                    yValue.add(i * 60);
                }

                chartView.setValue(value, xValue, yValue);
            }
        });


    }

    private void setMoth() {
        xValue.clear();
        value.clear();
        yValue.clear();
        for (int i = 0; i < 12; i++) {
            xValue.add((i + 1) + "月");
            value.put((i + 1) + "月", (int) (Math.random() * 181 + 60));//60--240
        }

        for (int i = 0; i < 6; i++) {
            yValue.add(i * 60);
        }


        chartView.setValue(value, xValue, yValue);
    }
}
