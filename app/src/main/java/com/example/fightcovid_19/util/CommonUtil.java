package com.example.fightcovid_19.util;


import com.example.fightcovid_19.entity.UserEntity;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
    static UserEntity userEntity;


    public static UserEntity getUserEntity() {
        return userEntity;
    }

    public static  void setUserEntity(UserEntity residentEntity1) {
        userEntity = residentEntity1;
    }

    public static Date getWeekStartDate(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();return date;
    }
    public static Date getMonthDate(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//1:本月第一天
        Date date = c.getTime();
        return date;
    }
}
