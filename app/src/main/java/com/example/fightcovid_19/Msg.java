package com.example.fightcovid_19;

/*
 *存放评论区消息
 */
public class Msg {
    public String content;
    public String username;

    public Msg(String content,String username){
        this.username = username;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }
}

