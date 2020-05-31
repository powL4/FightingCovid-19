package com.example.fightcovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fightcovid_19.R;

/**
 * 查看数据
 */
public class ViewDataActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_1;
    private Button button_2;
    private Button button_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_view_data);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);

        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button_1:         //条形图
                intent = new Intent(ViewDataActivity.this, BarActivity.class);
                startActivity(intent);
                break;
            case R.id.button_2:         //饼状图
                intent = new Intent(ViewDataActivity.this, PieActivity.class);
                startActivity(intent);
                break;
            case R.id.button_3:         //折线图
                intent = new Intent(ViewDataActivity.this, LineActivity.class);
                startActivity(intent);
                break;

        }
    }
}
