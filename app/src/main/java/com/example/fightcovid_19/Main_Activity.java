package com.example.fightcovid_19;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.SharedLibraryInfo;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fightcovid_19.activity.ViewDataActivity;
import com.example.fightcovid_19.util.HttpUtil;

import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main_Activity extends Activity implements View.OnClickListener {

    private Button button_1;
    private Button button_2;
    private ImageView bingPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main_layout);
        initView();
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        bingPic = (ImageView) findViewById(R.id.bing_pic);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String bingpic = prefs.getString("bing_pic",null);
        if(bingpic != null){
            Glide.with(this).load(bingpic).into(bingPic);
        }else{
            loadBingPic();
        }
    }

    private void initView() {
        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(this);


        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                Intent intent=new Intent(Main_Activity.this,Commetdist_Activity.class);
                startActivity(intent);
                break;
            case R.id.button_2:         //查看数据
                Intent intent1=new Intent(Main_Activity.this, ViewDataActivity.class);
                startActivity(intent1);
        }
    }
    private void loadBingPic(){
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String bingpics = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(Main_Activity.this).edit();
                editor.putString("bing_pic",bingpics);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(Main_Activity.this).load(bingpics).into(bingPic);
                    }
                });
            }
        });
    }

}
