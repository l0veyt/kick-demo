package com.xinlee.demo.servlet;

import com.xinlee.demo.util.OnlineUsers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//把登陆的用户显示出来
public class ShowOnlineUsersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, HttpSession> map = OnlineUsers.getAllUsers();
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listUsers.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
