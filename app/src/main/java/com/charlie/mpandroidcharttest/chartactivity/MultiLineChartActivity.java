package com.charlie.mpandroidcharttest.chartactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.DataGroupComputer;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class MultiLineChartActivity extends AppCompatActivity {

    private LineChart lineChart;
    private List<String> xAxisValues;
    private List<String> titles;
    private List<List<Float>> yAxisValues;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        initView();
        initData();
        MPChartHelper.setLinesChart(lineChart,xAxisValues,yAxisValues,titles,false,null);
    }

    private void initView(){
        lineChart=(LineChart)findViewById(R.id.lineChart);
        intent = getIntent();
    }

    private void initData(){
        xAxisValues = new ArrayList<>();

        Bundle bundle = intent.getExtras();
        String dataString = bundle.getString("dataString");

        DataGroupComputer dataGroupComputer = new DataGroupComputer();
        dataGroupComputer.setDataStringAndChangeItToDataList(dataString);

        List<Float> WDList = dataGroupComputer.getWenduDataList();
        List<Float> SDList = dataGroupComputer.getShiduDataList();
//        List<Float> yAxisValues3 = new ArrayList<>();

        for(int i=0;i<10;++i){
            xAxisValues.add(String.valueOf(i));
//            yAxisValues1.add((float)(Math.random()*20+20));
//            yAxisValues2.add((float)(Math.random()*20+40));
//            yAxisValues3.add((float)(Math.random()*20+60));
        }



        yAxisValues = new ArrayList<>();
        yAxisValues.add(WDList);
        yAxisValues.add(SDList);
//        yAxisValues.add(yAxisValues3);

        titles = new ArrayList<>();
        titles.add("温度");
        titles.add("湿度");
//        titles.add("折线3");

        //设置背景延伸到状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
