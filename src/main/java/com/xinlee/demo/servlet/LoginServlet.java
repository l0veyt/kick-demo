package com.xinlee.demo.servlet;

import com.xinlee.demo.pojo.User;
import com.xinlee.demo.util.UserDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xin.lee on 2017/3/3.
 * 登录
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        String password = request.getParameter("password");
        User user = UserDB.find(username, password);
        if(user == null) {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("错误的用户名或密码；3秒后转向登陆页面");
            response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/login.jsp");
            return;
        }
        //用户名和密码正确
        HttpSession session = request.getSession();
        session.setAttribute("user", user);//记住登陆信息:利用监听器
        response.sendRedirect(request.getContextPath() + "/");//重定向到主页
    }
}
