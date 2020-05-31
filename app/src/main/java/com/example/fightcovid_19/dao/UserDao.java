package com.example.fightcovid_19.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fightcovid_19.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static MySQLiteOpenHelper openHelper;

    public static final String TABLE_NAME = "user";

    public static final String  userid="userid";
    public static final String   number="number";
    public static final String   name="name";
    public static final String gender="gender";
    public static final String yuanxi="yuanxi";
    public static final String nianji="nianji";
    public static final String phonenumb="phonenumb";
    public static final String password="password";
  /*  public static final String name = "name";
*/
    private String dictionary_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
            + userid + " Integer primary key AUTOINCREMENT ,"
            + number + "  varchar(60) ,"
          + name + "  varchar(60) ,"
          + gender + "  varchar(60) ,"
          + yuanxi + "  varchar(60) ,"
          + nianji + "  varchar(60) ,"
          + phonenumb + "  varchar(60) ,"
            + password + " varchar(60)  )";
    ;
    Context context;
    public UserDao(Context context){
        this.context = context;
        if(openHelper==null){
            openHelper =MySQLiteOpenHelper.getInstance(context);
        }
    }

    public void createTableIns(){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL(dictionary_sql);
    }

    public List<UserEntity> queryAllData(String selection, String[] args){
        SQLiteDatabase db=openHelper.getWritableDatabase();
        Cursor cursor =null;
        try {
            cursor=   db.query(TABLE_NAME, null, selection, args, null, null, null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        List<UserEntity>list=new ArrayList<>();
        if(cursor==null){
            return null;
        }
        while (cursor.moveToNext()) {
            UserEntity q = new UserEntity();
           q.setUserid(cursor.getInt(cursor.getColumnIndex(userid)));
           q.setNumber(cursor.getString(cursor.getColumnIndex(number)));
            q.setName(cursor.getString(cursor.getColumnIndex(name)));
            q.setGender(cursor.getString(cursor.getColumnIndex(gender)));
            q.setYuanxi(cursor.getString(cursor.getColumnIndex(yuanxi)));
            q.setNianji(cursor.getString(cursor.getColumnIndex(nianji)));
            q.setPhonenumb(cursor.getString(cursor.getColumnIndex(phonenumb)));
           q.setPassword(cursor.getString(cursor.getColumnIndex(password)));
          // q.setName(cursor.getString(cursor.getColumnIndex(name)));
            list.add(q);
        }
        db.close();
        return list;
    }

    public UserEntity queryData(String selection,String[] values){
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
        UserEntity q = null;
        while (cursor.moveToNext()) {
           q = new UserEntity();
            q.setUserid(cursor.getInt(cursor.getColumnIndex(userid)));
            q.setNumber(cursor.getString(cursor.getColumnIndex(number)));
            q.setName(cursor.getString(cursor.getColumnIndex(name)));
            q.setGender(cursor.getString(cursor.getColumnIndex(gender)));
            q.setYuanxi(cursor.getString(cursor.getColumnIndex(yuanxi)));
            q.setNianji(cursor.getString(cursor.getColumnIndex(nianji)));
            q.setPhonenumb(cursor.getString(cursor.getColumnIndex(phonenumb)));
            q.setPassword(cursor.getString(cursor.getColumnIndex(password)));
        //    q.setName(cursor.getString(cursor.getColumnIndex(name)));
        }
        cursor.close();
        db.close();
        return q;
    }
    public void insertDB(UserEntity resEntity){
        SQLiteDatabase db = openHelper.getWritableDatabase();
            db.execSQL(dictionary_sql);
            ContentValues contentValues = new ContentValues();
            contentValues.put(number,resEntity.getNumber());
        contentValues.put(name,resEntity.getName());
        contentValues.put(gender,resEntity.getGender());
        contentValues.put(yuanxi,resEntity.getYuanxi());
        contentValues.put(nianji,resEntity.getNianji());
        contentValues.put(phonenumb,resEntity.getPhonenumb());


        contentValues.put(password,resEntity.getPassword());
      //      contentValues.put(name,resEntity.getName());
            db.insert(TABLE_NAME,null,contentValues);
    }
    public void updateUser(UserEntity resEntity){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL(dictionary_sql);
        ContentValues contentValues = new ContentValues();
        contentValues.put(number,resEntity.getNumber());
        contentValues.put(name,resEntity.getName());
        contentValues.put(gender,resEntity.getGender());
        contentValues.put(yuanxi,resEntity.getYuanxi());
        contentValues.put(nianji,resEntity.getNianji());
        contentValues.put(phonenumb,resEntity.getPhonenumb());
        contentValues.put(password,resEntity.getPassword());
     //   contentValues.put(name,resEntity.getName());
        db.update(TABLE_NAME,contentValues," userid=?",new String[]{resEntity.getUserid()+""});
    }
}
