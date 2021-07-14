package com.sdu.dao;

import com.sdu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Dao的基类，封装了常用的增删改查方法,抽象类
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     *
     * @param sql 需要执行的sql语句（增删改操作）
     * @param args 需要填充占位符的不定参数
     * @return 返回被影响的行数，如果错误则返回-1。
     */
    public int update(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    /**
     *
     * @param type 需要查询的对象所属类
     * @param sql  查询sql语句
     * @param args 填充占位符参数
     * @param <T>  范型
     * @return     符合条件的单个对象，若为null则无符合的对象
     */
    public <T> T queryOneBean(Class<T> type,String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            T query = queryRunner.query(connection,sql, new BeanHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    /**
     *
     * @param type 需要查询的对象所属类
     * @param sql  查询sql语句
     * @param args 填充占位符参数
     * @param <T>  范型
     * @return     符合条件的对象列表，若为null则无符合的对象
     */
    public <T> List<T> getListBeans(Class<T> type,String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }


}
