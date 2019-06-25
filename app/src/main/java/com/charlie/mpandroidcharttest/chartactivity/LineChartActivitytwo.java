package com.charlie.mpandroidcharttest.chartactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.DataGroupComputer;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class LineChartActivitytwo extends AppCompatActivity {

    private LineChart lineChart;
    private List<String> xAxisValues;
    private List<Float> yAxisValues;

    private Intent intent;
    private String titleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_charttwo);

        initView();
        initData();
        MPChartHelper.setLineChart(lineChart,xAxisValues,yAxisValues,titleName,true);

    }

    private void initView(){
        lineChart=(LineChart)findViewById(R.id.lineChart2);
    }

    private void initData(){
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String dataString = bundle.getString("dataString");
        int tag = bundle.getInt("Tag");

        xAxisValues = new ArrayList<>();
        yAxisValues = new ArrayList<>();
        for(int i=0;i<10;++i){
            xAxisValues.add(String.valueOf(i));
        }

        DataGroupComputer dataGroupComputer = new DataGroupComputer();
        dataGroupComputer.setDataStringAndChangeItToDataList(dataString);

        switch (tag){
            case 1:
                yAxisValues = dataGroupComputer.getWenduDataList();
                titleName = "温度";
                break;

            case 2:
                yAxisValues = dataGroupComputer.getShiduDataList();
                titleName = "湿度";
                break;

            case 3:
                yAxisValues = dataGroupComputer.getGuangduduDataList();
                titleName = "光敏阻值";
                break;

            case 4:
                yAxisValues = dataGroupComputer.getYanwuDataList();
                titleName = "烟雾参值";
                break;
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
