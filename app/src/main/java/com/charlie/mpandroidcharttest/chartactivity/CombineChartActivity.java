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
import com.github.mikephil.charting.charts.CombinedChart;

import java.util.ArrayList;
import java.util.List;

public class CombineChartActivity extends AppCompatActivity {

    private CombinedChart combineChart;
    private List<String> xAxisValues;
    private List<Float> lineValues;
    private List<Float> barValues;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine_chart);

        initView();
        initData();
        MPChartHelper.setCombineChart(combineChart,xAxisValues,lineValues,barValues,"温度","湿度");
    }

    private void initView(){
        combineChart=(CombinedChart)findViewById(R.id.combineChart);
        intent = getIntent();
    }

    private void initData(){
        xAxisValues = new ArrayList<>();

        Bundle bundle = intent.getExtras();
        String dataString = bundle.getString("dataString");

        DataGroupComputer dataGroupComputer = new DataGroupComputer();
        dataGroupComputer.setDataStringAndChangeItToDataList(dataString);

        lineValues = dataGroupComputer.getWenduDataList();
        barValues = dataGroupComputer.getShiduDataList();

        for(int i=0;i<10;++i){
            xAxisValues.add(String.valueOf(i));
//            lineValues.add((float)(Math.random()*1000+20));
//            barValues.add((float)(Math.random()*1000+20));
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
