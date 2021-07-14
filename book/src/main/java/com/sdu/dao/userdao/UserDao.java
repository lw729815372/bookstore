package com.sdu.dao.userdao;

import com.sdu.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 用于检查该用户名是否可用
     * @param name 输入用户名
     * @return 返回则已经存在，返回null则没有该用户名用户
     */
    public User getUserByName(String name);

    /**
     * 查询是否用户名、密码正确
     * @param name 输入用户名
     * @param password 输入对应密码
     * @return 返回User对象则输入正确，否则用户名或密码错误
     */
    public User query4One(String name,String password);

    /**
     * 存储user信息到db
     * @param user 要被存储的user对象
     * @return  返回被影响的行数，-1则为执行失败
     */
    public int saveUser(User user);
}
