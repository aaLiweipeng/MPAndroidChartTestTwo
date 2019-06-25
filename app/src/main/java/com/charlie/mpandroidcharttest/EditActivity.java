package com.charlie.mpandroidcharttest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.charlie.mpandroidcharttest.chartactivity.LineChartActivitytwo;
import com.charlie.mpandroidcharttest.util.DataGroupComputer;

import java.util.List;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ac_et_et;

    private Button ac_et_bt_confirmData;
//    private Button ac_et_bt_savaData;

    private CardView ac_et_cardView_WD;
    private CardView ac_et_cardView_SD;
    private CardView ac_et_cardView_GM;
    private CardView ac_et_cardView_YW;

    private TextView ac_et_AvgText;
    private TextView ac_et_MaxText;
    private TextView ac_et_MinText;

    private TextView ac_et_SDAvgText;
    private TextView ac_et_SDMaxText;
    private TextView ac_et_SDMinText;

    private TextView ac_et_GMAvgText;
    private TextView ac_et_GMMaxText;
    private TextView ac_et_GMMinTag;

    private TextView ac_et_YWAvgText;
    private TextView ac_et_YWMaxText;
    private TextView ac_et_YWMinText;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();
        initViewsConfig();

    }


    private void initViews() {
        ac_et_et = (EditText) findViewById(R.id.ac_et_et);
        ac_et_bt_confirmData = (Button)findViewById(R.id.ac_et_bt_confirmData);

        ac_et_cardView_WD = (CardView)findViewById(R.id.ac_et_cardView_WD);
        ac_et_cardView_SD = (CardView)findViewById(R.id.ac_et_cardView_SD);
        ac_et_cardView_GM = (CardView)findViewById(R.id.ac_et_cardView_GM);
        ac_et_cardView_YW = (CardView)findViewById(R.id.ac_et_cardView_YW);

        ac_et_AvgText = (TextView) findViewById(R.id.ac_et_AvgText);
        ac_et_MaxText = (TextView) findViewById(R.id.ac_et_MaxText);
        ac_et_MinText = (TextView) findViewById(R.id.ac_et_MinText);

        ac_et_SDAvgText = (TextView) findViewById(R.id.ac_et_SDAvgText);
        ac_et_SDMaxText = (TextView) findViewById(R.id.ac_et_SDMaxText);
        ac_et_SDMinText = (TextView) findViewById(R.id.ac_et_SDMinText);

        ac_et_GMAvgText = (TextView) findViewById(R.id.ac_et_GMAvgText);
        ac_et_GMMaxText = (TextView) findViewById(R.id.ac_et_GMMaxText);
        ac_et_GMMinTag = (TextView) findViewById(R.id.ac_et_GMMinText);

        ac_et_YWAvgText = (TextView) findViewById(R.id.ac_et_YWAvgText);
        ac_et_YWMaxText = (TextView) findViewById(R.id.ac_et_YWMaxText);
        ac_et_YWMinText = (TextView) findViewById(R.id.ac_et_YWMinText);


        ac_et_cardView_WD.setOnClickListener(this);
        ac_et_cardView_SD.setOnClickListener(this);
        ac_et_cardView_GM.setOnClickListener(this);
        ac_et_cardView_YW.setOnClickListener(this);
        ac_et_bt_confirmData.setOnClickListener(this);

//        ac_et_AvgText
//        ac_et_MaxText
//        ac_et_MinText
//
//        ac_et_SDAvgText
//        ac_et_SDMaxText
//        ac_et_SDMinText
//
//        ac_et_GMAvgText
//        ac_et_GMMaxText
//        ac_et_GMMinTag
//
//        ac_et_YWAvgText
//        ac_et_YWMaxText
//        ac_et_YWMinText
    }

    private void initViewsConfig() {
        //把组件的宽度设置成屏幕的一半
        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();
        //      拿到布局参数
        ViewGroup.LayoutParams l = ac_et_et.getLayoutParams();
        l.height=d.getHeight()/3;

        ac_et_et.setText("29.30*68.00*199*50*29.30*68.00*197*48*29.30*71.00*" +
                "199*50*29.30*71.00*199*46*29.50*68.00*200*51*29.50*68.00*198*" +
                "45*29.10*68.00*200*51*29.10*68.00*199*46*29.40*68.00*200*51*" +
                "29.40*68.00*199*46*");

        ac_et_AvgText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_MaxText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_MinText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );

        ac_et_SDAvgText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_SDMaxText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_SDMinText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );

        ac_et_GMAvgText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_GMMaxText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_GMMinTag.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );

        ac_et_YWAvgText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_YWMaxText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        ac_et_YWMinText.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );

        //设置背景延伸到状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();
        bundle.putString("dataString",ac_et_et.getText().toString() );

        switch (v.getId()){
            case R.id.ac_et_bt_confirmData:
                setCardViewText();
                break;
            case R.id.ac_et_cardView_WD:
                intent = new Intent(EditActivity.this, ChartSelectActivity.class);
                bundle.putInt("Tag",1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ac_et_cardView_SD:
                intent = new Intent(EditActivity.this, ChartSelectActivity.class);
                bundle.putInt("Tag",2);

                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ac_et_cardView_GM:
                intent = new Intent(EditActivity.this, ChartSelectActivity.class);
                bundle.putInt("Tag",3);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.ac_et_cardView_YW:
                intent = new Intent(EditActivity.this, ChartSelectActivity.class);
                bundle.putInt("Tag",4);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }

    private void setCardViewText() {
        DataGroupComputer dataGroupComputer = new DataGroupComputer();
        dataGroupComputer.setDataStringAndChangeItToDataList(ac_et_et.getText().toString());
        List<Float> wdList = dataGroupComputer.getWenduDataList();
        List<Float> sdList = dataGroupComputer.getShiduDataList();
        List<Float> gmList = dataGroupComputer.getGuangduduDataList();
        List<Float> ywList = dataGroupComputer.getYanwuDataList();

        ac_et_AvgText.setText(dataGroupComputer.getTheAvgOfList(wdList));
        ac_et_MaxText.setText(dataGroupComputer.getTheMaxOfList(wdList));
        ac_et_MinText.setText(dataGroupComputer.getTheMinOfList(wdList));

        ac_et_SDAvgText.setText(dataGroupComputer.getTheAvgOfList(sdList));
        ac_et_SDMaxText.setText(dataGroupComputer.getTheMaxOfList(sdList));
        ac_et_SDMinText.setText(dataGroupComputer.getTheMinOfList(sdList));

        ac_et_GMAvgText.setText(dataGroupComputer.getTheAvgOfList(gmList));
        ac_et_GMMaxText.setText(dataGroupComputer.getTheMaxOfList(gmList));
        ac_et_GMMinTag.setText(dataGroupComputer.getTheMinOfList(gmList));

        ac_et_YWAvgText.setText(dataGroupComputer.getTheAvgOfList(ywList));
        ac_et_YWMaxText.setText(dataGroupComputer.getTheMaxOfList(ywList));
        ac_et_YWMinText.setText(dataGroupComputer.getTheMinOfList(ywList));
    }

//    <Button
//    android:id="@+id/ac_et_bt_savaData"
//    android:text="保存数据"
//    android:textColor="@android:color/white"
//    android:layout_gravity="center_horizontal"
//    android:layout_margin="12dp"
//    android:layout_width="200dp"
//    android:layout_height="wrap_content"
//    android:background="@drawable/btn_press_state"/>
}
