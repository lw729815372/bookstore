package com.sdu.test;

import com.sdu.bean.User;
import com.sdu.dao.userdao.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void getUserByName() {
        User user = userDao.getUserByName("song");
        if (user!=null){
            System.out.println("用户名不可用");
        }else {
            System.out.println("用户名可用");
        }

    }

    @Test
    public void query4One() {
        User user = userDao.query4One("liwei", "6646261");
        if (user==null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        User user = new User(33,"songyajie","abc123","song@163.com");
        int i = userDao.saveUser(user);
        if (i>0){
            System.out.println("存入成功");
        }else {
            System.out.println("存入失败");
        }
    }
}