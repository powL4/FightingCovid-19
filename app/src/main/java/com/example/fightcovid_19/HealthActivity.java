package com.example.fightcovid_19;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.fightcovid_19.R;
import com.example.fightcovid_19.dao.HealthDao;
import com.example.fightcovid_19.entity.HealthEntity;
import com.example.fightcovid_19.util.CommonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthActivity extends Activity implements View.OnClickListener {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    HealthDao healthDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_layout);
        if(healthDao==null){
            healthDao=new HealthDao(this);
            healthDao.createTableIns();
        }
        initView();
        getData();
    }
    HealthEntity healthEntity;
    private void getData() {
        String userid = CommonUtil.getUserEntity().getUserid()+"";
        String cur_day = simpleDateFormat.format(new Date());
        healthEntity =  healthDao.queryData("userid=? and cur_day =? ",new String[]{userid,cur_day});
        if(healthEntity!=null){
            if(healthEntity.getCur_state().equals("健康")){
                jk_btn.setChecked(true);
            }else if(healthEntity.getCur_state().equals("医学观察")){
                yxgc_btn.setChecked(true);
            }else{
                hb_btn.setChecked(true);
            }
            sure_btn.setText("已登记");
        }else{
            sure_btn.setText("登记");
        }
    }
    RadioButton jk_btn,yxgc_btn,hb_btn;
    Button sure_btn;
    private void initView() {
        sure_btn= findViewById(R.id.button_login);
        sure_btn.setOnClickListener(this);
        jk_btn = findViewById(R.id.health_ok);
        yxgc_btn = findViewById(R.id.health_gc);
        hb_btn = findViewById(R.id.health_error);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                String cur_state="";
                if(jk_btn.isChecked()){
                    cur_state="健康";
                }else if(yxgc_btn.isChecked()){
                    cur_state="医学观察";
                }else{
                    cur_state = "患病";
                }
                if(healthEntity==null){


                    healthEntity =new HealthEntity();
                    healthEntity.setUserid(CommonUtil.getUserEntity().getUserid());
                    healthEntity.setCur_day(simpleDateFormat.format(new Date()));
                    healthEntity.setCur_state(cur_state);
                    healthDao.insertDB(healthEntity);
                    Toast.makeText(this,"登记成功",Toast.LENGTH_LONG).show();

                }else{
                    healthEntity.setCur_state(cur_state);
                    healthDao.updateUser(healthEntity);
                }
                Intent i = new Intent(this,Main_Activity.class);
                this.startActivity(i);
                this.finish();
                break;
        }
    }
}
