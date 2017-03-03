package com.xinlee.demo.util;

import com.xinlee.demo.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin.lee on 2017/3/3.
 * 模拟数据库用户表
 */
public class UserDB {
    // 存放用户
    private static List<User> userList = new ArrayList<User>();
    static {
        userList.add(new User("张三", "23"));
        userList.add(new User("李四", "24"));
    }
    public static User find(String username, String password) {
        User user = null;
        for (User temp : userList) {
            if(temp.getUsername().equals(username) && temp.getPassword().equals(password)) {
                user = temp;
                break;
            }
        }
        return user;
    }
}
