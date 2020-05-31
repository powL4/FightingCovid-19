package com.example.fightcovid_19.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MyPreferenceUtil {
	Context context;
	String fileName = "fightcovid_19";

	public MyPreferenceUtil(Context context) {
		this.context = context;
	}

	/**
	 * 保存字符串
	 * 
	 * @param key
	 * @param value
	 */
	public void saveStringVlue(String key, String value) {
		SharedPreferences preference = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		Editor edit = preference.edit();
		edit.putString(key, value);
		edit.commit();

	}

	/**
	 * 读取字符串
	 */
	public String getStringValue(String key) {
		SharedPreferences preference = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		String str = preference.getString(key, null);
		return str;
	}

	public void removeSharePreferences(String key) {
		SharedPreferences preference = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		Editor edit = preference.edit();
		edit.remove(key);
		edit.commit();
	}

	/**
	 * 保存字符串
	 * 
	 * @param key
	 * @param value
	 */
	public void saveLongVlue(String key, long value) {
		SharedPreferences preference = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		Editor edit = preference.edit();
		edit.putLong(key, value);
		edit.commit();

	}

	/**
	 * 读取字符串
	 */
	public long getLongValue(String key) {
		SharedPreferences preference = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		long str = preference.getLong(key, 0);
		return str;
	}

}
