package com.sdu.web;

import com.sdu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("This is loginServlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.login(username,password)==null){
            request.setAttribute("msg","用户名或密码错误，登陆失败！ ");
            request.setAttribute("username",username);
            System.out.println("用户名或密码错误，登陆失败！");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }

    }


}
