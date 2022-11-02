package com.mysql.hikari;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author yxg
 */
public class HikariDataSourceFactory extends UnpooledDataSourceFactory {
    public HikariDataSourceFactory() {
       // HikariConfig config = new HikariConfig("src/main/resources/mybatis/application.properties");
//        config.setMaxLifetime(40000);
//        config.setKeepaliveTime(30000);
//        config.setMaximumPoolSize(2);
//        config.setLeakDetectionThreshold(500000);
//        config.setIdleTimeout(40000);
//        config.setConnectionTimeout(40000);
//        config.setValidationTimeout(3000);
        this.dataSource = new HikariDataSource();
    }
}
