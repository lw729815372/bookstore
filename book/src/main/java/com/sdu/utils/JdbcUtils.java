package com.sdu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            InputStream stream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池中的连接
     * @return 一个连接
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接并放回连接池
     * @param connection 需要被关闭的连接
     */
    public static void closeConnection(Connection connection){
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
