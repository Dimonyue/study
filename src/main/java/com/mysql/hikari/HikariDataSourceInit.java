package com.mysql.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yxg
 */
public class HikariDataSourceInit {
    private static final HikariConfig config = new HikariConfig();
    private static com.zaxxer.hikari.HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://192.168.101.54:33306/heraclitus?ssl=false&serverTimezone=GMT%2B8");
        config.setUsername("root");
        config.setPassword("123456");
        config.addDataSourceProperty("connection-test-query", "select 1");
        ds = new com.zaxxer.hikari.HikariDataSource(config);
    }

    private HikariDataSourceInit() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
