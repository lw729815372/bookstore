package com.sdu.service;

import com.sdu.bean.User;
import com.sdu.dao.userdao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.query4One(name, password);
        return user;
    }

    @Override
    public boolean isExist(String name) {
        User userByName = userDao.getUserByName(name);
        if (userByName==null){
            return false;
        }else {
            return true;
        }
    }
}
