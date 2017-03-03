package com.xinlee.demo.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class OnlineUsers {
	//存放登陆的用户名及该用户对应的HttpSession对象
	private static Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	public static Map<String, HttpSession> getAllUsers(){
		return map;
	}
}
