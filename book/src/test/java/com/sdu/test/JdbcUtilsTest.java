package com.sdu.test;

import com.sdu.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class JdbcUtilsTest {

    @Test
    void getConnection() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.closeConnection(connection);
        }
    }

    @Test
    void closeConnection() {
    }
}