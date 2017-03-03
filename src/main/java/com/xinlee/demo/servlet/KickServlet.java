package com.xinlee.demo.servlet;

import com.xinlee.demo.util.OnlineUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
//踢出
public class KickServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		//首先从存放用户的map中找到对应的HttpSession，让HttpSession失效
		Map<String, HttpSession> map = OnlineUsers.getAllUsers();
		HttpSession session = map.get(username);
		if(session!=null){
			session.invalidate();
		}
		//从map中把key删除掉
		map.remove(username);
		//重定向到主页
		response.sendRedirect(request.getContextPath() + "/");
	}
}
