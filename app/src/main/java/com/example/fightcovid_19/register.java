package com.example.fightcovid_19;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fightcovid_19.dao.UserDao;
import com.example.fightcovid_19.entity.UserEntity;
public class register extends Activity implements View.OnClickListener {

    //  final   long username1 = Integer.parseInt(username.getText().toString());
    // final  long pw1 = Integer.parseInt(pw.getText().toString());
    //final  long house1 = Integer.parseInt(house.getText().toString());
	UserDao userDao;
	EditText number,name,phone,password;
	RadioButton man_btn,woman_btn;
	Spinner yuanxi_spinner,nianji_spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initView();
    }

	private  void initView(){
    	number = findViewById(R.id.et_number);
		 name = (EditText) findViewById(R.id.et_name);
		 man_btn = findViewById(R.id.gender_m);
		 woman_btn  = findViewById(R.id.gender_wm);
		 yuanxi_spinner = findViewById(R.id.yuanxi_spinner);
		 nianji_spinner = findViewById(R.id.nianji_spinner);
		 phone = findViewById(R.id.et_phone);
		 password = (EditText) findViewById(R.id.et_psd);
		 findViewById(R.id.button_register).setOnClickListener(this);
		 findViewById(R.id.back_iv).setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.button_register:
				if(checkInfo()){
					regist();
				}

				break;
			case R.id.back_iv:
				this.finish();
				break;
		}
	}
	private  void regist(){
		//	String namev = name.getText().toString();
		String numberv =number.getText().toString();
		String namev = name.getText().toString();
			String phonev = phone.getText().toString();
			String psdv = password.getText().toString();
			String gender ="";
			if(man_btn.isChecked()){
				gender="男";
			}else{
				gender="女";
			}
			String yuanxi = yuanxi_spinner.getSelectedItem().toString();
			String nianji = nianji_spinner.getSelectedItem().toString();
				if(userDao==null){
					userDao =new UserDao(this);
					userDao.createTableIns();
				}
				UserEntity ren =  userDao.queryData("number =?" ,new String[]{numberv});
				if(ren!=null){
					Toast.makeText(this,"该用户已存在！",Toast.LENGTH_LONG).show();
					return;
				}
		UserEntity rentity = new UserEntity();
			rentity.setNumber(numberv);
			rentity.setName(namev);
			rentity.setGender(gender);
			rentity.setYuanxi(yuanxi);
			rentity.setNianji(nianji);
			rentity.setPhonenumb(phonev);
			rentity.setPassword(psdv);
		userDao.insertDB(rentity);
			/*	Intent intent = new Intent(register.this,resident.class);
				startActivity(intent);
*/
			Toast.makeText(this,"注册成功，请用学号登录！",Toast.LENGTH_LONG).show();
			this.finish();
	}

	private boolean checkInfo(){
		if(number.getText()==null||number.getText().toString().isEmpty()){
			Toast.makeText(this,"请输入学号！",Toast.LENGTH_LONG).show();
			return false;
		}
		if(name.getText()==null||name.getText().toString().isEmpty()){
			Toast.makeText(this,"请输入姓名！",Toast.LENGTH_LONG).show();
			return false;
		}
		if(phone.getText()==null||phone.getText().toString().isEmpty()){
			Toast.makeText(this,"请输入电话！",Toast.LENGTH_LONG).show();
			return false;
		}
		if(password.getText()==null||password.getText().toString().isEmpty()){
			Toast.makeText(this,"请输入密码！",Toast.LENGTH_LONG).show();
			return false;
		}
		/*if(name.getText()==null||name.getText().toString().isEmpty()){
			Toast.makeText(this,"请输入姓名！",Toast.LENGTH_LONG).show();
			return false;
		}*/
    	return true;
	}

}