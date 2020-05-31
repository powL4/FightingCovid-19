package com.example.fightcovid_19.entity;

import java.io.Serializable;

public class HealthEntity implements Serializable {
    int id;
    int userid;
    String cur_day;
    String cur_state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCur_day() {
        return cur_day;
    }

    public void setCur_day(String cur_day) {
        this.cur_day = cur_day;
    }

    public String getCur_state() {
        return cur_state;
    }

    public void setCur_state(String cu_state) {
        this.cur_state = cu_state;
    }
}
