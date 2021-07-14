package com.sdu.dao.userdao;

import com.sdu.bean.User;
import com.sdu.dao.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User getUserByName(String name) {
        String sql = "select id,username,password,email from t_user where username = ?";

        User user = queryOneBean(User.class, sql, name);
        return user;
    }

    @Override
    public User query4One(String name, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        User user = queryOneBean(User.class, sql, name, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;

    }
}
