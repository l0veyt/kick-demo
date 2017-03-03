package com.xinlee.demo.pojo;

import com.xinlee.demo.util.OnlineUsers;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * Created by xin.lee on 2017/3/3.
 * 用户实体类
 */
public class User implements Serializable, HttpSessionBindingListener {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //只要User对象绑到HttpSession中，该方法就会执行
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();//当前用户对应的HttpSession对象
        //找一个容器把它存起来
        OnlineUsers.getAllUsers().put(username, session);
    }

    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
