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
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

public class TwoBarChartActivity extends AppCompatActivity {

    private BarChart barChart1;

    private List<Integer> xAxisValues;
//    private List<Float> yAxisValues1;
//    private List<Float> yAxisValues2;
    private List<Float> WDList;
    private List<Float> SDList;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        initView();
        initData();
        MPChartHelper.setTwoBarChart(barChart1,xAxisValues,WDList,SDList,"温度","湿度");
    }

    private void initView(){
        barChart1=(BarChart)findViewById(R.id.barChart1);
        intent = getIntent();
    }

    private void initData(){
        xAxisValues = new ArrayList<>();
//        yAxisValues1 = new ArrayList<>();
//        yAxisValues2 = new ArrayList<>();


        Bundle bundle = intent.getExtras();
        String dataString = bundle.getString("dataString");

        DataGroupComputer dataGroupComputer = new DataGroupComputer();
        dataGroupComputer.setDataStringAndChangeItToDataList(dataString);

        WDList = dataGroupComputer.getWenduDataList();
        SDList = dataGroupComputer.getShiduDataList();

        for(int i=0;i<10;++i){
            xAxisValues.add(i);
//            yAxisValues1.add((float)(Math.random()*800+20));
//            yAxisValues2.add((float)(Math.random()*1000+20));
        }

        //设置背景延伸到状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


    }
}
