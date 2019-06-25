package com.charlie.mpandroidcharttest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.charlie.mpandroidcharttest.chartactivity.CombineChartActivity;
import com.charlie.mpandroidcharttest.chartactivity.LineChartActivitytwo;
import com.charlie.mpandroidcharttest.chartactivity.MultiLineChartActivity;
import com.charlie.mpandroidcharttest.chartactivity.TwoBarChartActivity;

public class ChartSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView ac_chartselect_ZZTScv;
    private CardView ac_chartselect_ZXTDcv;
    private CardView ac_chartselect_ZXTScv;
    private CardView ac_chartselect_ZHTcv;

    private Intent intent;
    private String dataString;
    private int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_select);

        initViews();
        initViewsConfig();


    }

    private void initViews() {
        ac_chartselect_ZZTScv = (CardView) findViewById(R.id.ac_chartselect_ZZTScv);
        ac_chartselect_ZXTDcv = (CardView) findViewById(R.id.ac_chartselect_ZXTDcv);
        ac_chartselect_ZXTScv = (CardView) findViewById(R.id.ac_chartselect_ZXTScv);
        ac_chartselect_ZHTcv = (CardView) findViewById(R.id.ac_chartselect_ZHTcv);
    }

    private void initViewsConfig() {
        ac_chartselect_ZZTScv.setOnClickListener(this);
        ac_chartselect_ZXTDcv.setOnClickListener(this);
        ac_chartselect_ZXTScv.setOnClickListener(this);
        ac_chartselect_ZHTcv.setOnClickListener(this);

        intent = intent = getIntent();
        Bundle bundle = intent.getExtras();
        dataString = bundle.getString("dataString");
        tag = bundle.getInt("Tag");

        //设置背景延伸到状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        showCardView(tag);
    }

    private void showCardView(int tag) {
        switch (tag){
            case 1:
                ac_chartselect_ZZTScv.setVisibility(View.VISIBLE);
                ac_chartselect_ZXTDcv.setVisibility(View.VISIBLE);
                ac_chartselect_ZXTScv.setVisibility(View.VISIBLE);
                ac_chartselect_ZHTcv.setVisibility(View.VISIBLE);
                break;

            case 2:
                ac_chartselect_ZZTScv.setVisibility(View.VISIBLE);
                ac_chartselect_ZXTDcv.setVisibility(View.VISIBLE);
                ac_chartselect_ZXTScv.setVisibility(View.VISIBLE);
                ac_chartselect_ZHTcv.setVisibility(View.VISIBLE);
                break;

            case 3:
                ac_chartselect_ZXTDcv.setVisibility(View.VISIBLE);
                break;

            case 4:
                ac_chartselect_ZXTDcv.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();
        bundle.putString("dataString",dataString );
        Intent intentGo;

        switch (v.getId()){
            case R.id.ac_chartselect_ZZTScv:
                intentGo = new Intent(ChartSelectActivity.this, TwoBarChartActivity.class);

                intentGo.putExtras(bundle);
                startActivity(intentGo);
                break;

            case R.id.ac_chartselect_ZXTDcv:
                intentGo = new Intent(ChartSelectActivity.this, LineChartActivitytwo.class);
                bundle.putInt("Tag",tag);
                intentGo.putExtras(bundle);
                startActivity(intentGo);
                break;

            case R.id.ac_chartselect_ZXTScv:
                intentGo = new Intent(ChartSelectActivity.this, MultiLineChartActivity.class);

                intentGo.putExtras(bundle);
                startActivity(intentGo);
                break;

            case R.id.ac_chartselect_ZHTcv:
                intentGo = new Intent(ChartSelectActivity.this, CombineChartActivity.class);

                intentGo.putExtras(bundle);
                startActivity(intentGo);
                break;
        }
    }
}
