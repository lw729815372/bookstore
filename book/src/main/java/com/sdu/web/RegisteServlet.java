package com.sdu.web;

import com.sdu.bean.User;
import com.sdu.service.UserService;
import com.sdu.service.UserServiceImpl;

import java.io.IOException;

public class RegisteServlet extends javax.servlet.http.HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2.检查验证码是否正确
        if ("6646".equals(code)){
            //3.检查用户名是否可用
            if (userService.isExist(username)){
                //此时已经存在，跳回注册页面
                System.out.println("用户名已存在！");
                request.setAttribute("msg","用户名已存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                //用户名可用
                userService.register(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else {
            System.out.println("验证码错误");
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }


}
