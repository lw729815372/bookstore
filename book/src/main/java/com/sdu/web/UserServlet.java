package com.sdu.web;

import com.sdu.bean.User;
import com.sdu.service.UserService;
import com.sdu.service.UserServiceImpl;
import com.sdu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 集合了所有user类的servlet，通过反射的方式调用不同的方法
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 处理注册功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2.检查验证码是否正确
        if ("6646".equals(code)){
            //3.检查用户名是否可用
            if (userService.isExist(username)){
                //此时已经存在，跳回注册页面
                System.out.println("用户名已存在！");
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //用户名可用
                userService.register(WebUtils.copyParamtoBean(req.getParameterMap(),new User()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            System.out.println("验证码错误");
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.login(username,password)==null){
            req.setAttribute("msg","用户名或密码错误，登陆失败！ ");
            req.setAttribute("username",username);
            System.out.println("用户名或密码错误，登陆失败！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }


}
