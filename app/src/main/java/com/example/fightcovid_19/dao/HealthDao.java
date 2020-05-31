package com.example.fightcovid_19.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fightcovid_19.entity.HealthEntity;
import com.example.fightcovid_19.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class HealthDao {
    private static MySQLiteOpenHelper openHelper;

    public static final String TABLE_NAME = "healthb";
    public static final String  id="id";
    public static final String  userid="userid";
    public static final String   cur_day="cur_day";
    public static final String   cur_state="cur_state";


    private String dictionary_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
            + id + " Integer primary key AUTOINCREMENT ,"
            + userid + "  Integer ,"
          + cur_day + "  varchar(60) ,"
            + cur_state + " varchar(60)  )";
    ;
    Context context;
    public HealthDao(Context context){
        this.context = context;
        if(openHelper==null){
            openHelper =MySQLiteOpenHelper.getInstance(context);
        }
    }

    public void createTableIns(){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL(dictionary_sql);
    }

    public List<HealthEntity> queryAllData(String selection, String[] args){
        SQLiteDatabase db=openHelper.getWritableDatabase();
        Cursor cursor =null;
        try {
            cursor=   db.query(TABLE_NAME, null, selection, args, null, null, null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        List<HealthEntity>list=new ArrayList<>();
        if(cursor==null){
            return null;
        }
        while (cursor.moveToNext()) {
            HealthEntity q = new HealthEntity();
            q.setId(cursor.getInt(cursor.getColumnIndex(id)));
           q.setUserid(cursor.getInt(cursor.getColumnIndex(userid)));
           q.setCur_day(cursor.getString(cursor.getColumnIndex(cur_day)));
            q.setCur_state(cursor.getString(cursor.getColumnIndex(cur_state)));
            list.add(q);
        }
        db.close();
        return list;
    }

    public HealthEntity queryData(String selection,String[] values){
        SQLiteDatabase db=openHelper.getWritableDatabase();
        Cursor cursor =null;
        try {
            cursor=   db.query(TABLE_NAME, null,selection, values, null, null, null, null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(cursor==null){
            return null;
        }
        HealthEntity q = null;
        while (cursor.moveToNext()) {
           q = new HealthEntity();
            q.setId(cursor.getInt(cursor.getColumnIndex(id)));
            q.setUserid(cursor.getInt(cursor.getColumnIndex(userid)));
            q.setCur_day(cursor.getString(cursor.getColumnIndex(cur_day)));
            q.setCur_state(cursor.getString(cursor.getColumnIndex(cur_state)));
        }
        cursor.close();
        db.close();
        return q;
    }
    public void insertDB(HealthEntity resEntity){
        SQLiteDatabase db = openHelper.getWritableDatabase();
            db.execSQL(dictionary_sql);
            ContentValues contentValues = new ContentValues();
            contentValues.put(userid,resEntity.getUserid());
        contentValues.put(cur_day,resEntity.getCur_day());
        contentValues.put(cur_state,resEntity.getCur_state());

            db.insert(TABLE_NAME,null,contentValues);
    }
    public void updateUser(HealthEntity resEntity){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL(dictionary_sql);
        ContentValues contentValues = new ContentValues();
        contentValues.put(userid,resEntity.getUserid());
        contentValues.put(cur_day,resEntity.getCur_day());
        contentValues.put(cur_state,resEntity.getCur_state());
        db.update(TABLE_NAME,contentValues," id=?",new String[]{resEntity.getId()+""});
    }
}
