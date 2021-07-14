package com.sdu.service;

import com.sdu.bean.User;

/**
 * 定义注册、登陆、检查用户名是否可用接口
 */
public interface UserService {
    /**
     *
     * @param user 要注册的用户
     */
    public void register(User user);

    /**
     *
     * @param name 登陆用户名
     * @param password 登陆密码
     * @return 返回对象登录成功，返回null登陆失败
     */
    public User login(String name,String password);

    /**
     *
     * @param name 要使用的用户名
     * @return 返回是否已存在，是-true，否-false
     */
    public boolean isExist(String name);
}
