package com.example.fightcovid_19;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.fightcovid_19.dao.UserDao;
import com.example.fightcovid_19.entity.UserEntity;
import com.example.fightcovid_19.util.CommonUtil;
import com.example.fightcovid_19.util.MyPreferenceUtil;

import java.util.List;

public class login extends Activity implements View.OnClickListener {


	UserDao residentDao;
	EditText username_et,psd_et;
	MyPreferenceUtil mp;
	  @Override
	  protected void onCreate(Bundle savedInstanceState) { 
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        mp = new MyPreferenceUtil(this);
	        findViewById(R.id.button_login).setOnClickListener(this);
	        findViewById(R.id.regist_tv).setOnClickListener(this);
	       username_et = findViewById(R.id.et_username);
	       psd_et = findViewById(R.id.et_password);


	   // tv= (TextView) this.findViewById(R.id.tv);

		  String savename = mp.getStringValue("uname");
		  String savevalue = mp.getStringValue("upsd");
		  username_et.setText(savename);
		  psd_et.setText(savevalue);
	     }

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.button_login:
				findViewById(R.id.et_username);
				if(username_et.getText().toString()==null||username_et.getText().toString().isEmpty()){
					Toast.makeText(this,"请输入账号",Toast.LENGTH_LONG).show();;
					return;
				}
				/*if(psd_et.getText().toString()==null||psd_et.getText().toString().isEmpty()){
					Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();;
					return;
				}*/
				String phonev = username_et.getText().toString();
				String psdv = psd_et.getText().toString();

					if(residentDao==null){
						residentDao =new UserDao(this);
						residentDao.createTableIns();
					}
					List<UserEntity> list = residentDao.queryAllData(null,null);
					list.size();
					UserEntity ren =  residentDao.queryData("number =? and password=?" ,new String[]{phonev,psdv});
					if(ren!=null){
						mp.saveStringVlue("uname",phonev);
						mp.saveStringVlue("upsd",psdv);
						CommonUtil.setUserEntity(ren);
						Intent intent = new Intent(login.this,HealthActivity.class);
						startActivity(intent);
						this.finish();
					}else{
						Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_LONG).show();
						return;
					}
			break;
			case R.id.regist_tv:
				Intent i = new Intent(this,register.class);
				this.startActivity(i);
				break;
		}
	}
}
