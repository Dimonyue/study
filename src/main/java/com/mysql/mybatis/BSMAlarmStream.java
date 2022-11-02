package com.mysql.mybatis;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 解析bsm event消息
 * v2v 的level等级需要+1
 * vru只要发生 就认为是warnning级别
 */
@Slf4j
public class BSMAlarmStream {
    private static AlarmMapper mapper = null;
    private static SqlSession session = null;

    private static Map<String,Integer> maps = new ConcurrentHashMap(16);

    private static final HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
        mapper = session.getMapper(AlarmMapper.class);

        LocalDateTime start = LocalDateTime.now();
        mapper.insertAlertCount(new BsmAlertCnt(1,1,1,1,null));

        while(true){
            LocalDateTime end = LocalDateTime.now();
            if(Duration.between(start,end).toMinutes() > 1){
                break;
            }
        }

        mapper.insertAlertCount(new BsmAlertCnt(2,2,2,2,null));

        while(true){
            LocalDateTime end = LocalDateTime.now();
            if(Duration.between(start,end).toMinutes() > 3){
                break;
            }
        }

        mapper.insertAlertCount(new BsmAlertCnt(3,3,3,3,null));

        System.out.println("插入数据成功");


//        final BSMAlarmService bsmAlarmService = new BSMAlarmService();
//        bsmAlarmService.insertAlertCount(new BsmAlertCnt(4,4,4,4,null));
//
//        Thread.sleep(2*60*1000);
//
//        bsmAlarmService.insertAlertCount(new BsmAlertCnt(5,5,5,5,null));


//        Properties properties = new Properties();
//        String appEnv = System.getenv("APP_ENV");
//        log.info("app_env:{}",appEnv);
//        try {
//            if (StrUtil.isEmpty(appEnv)) {
//                appEnv = "mybatis/application.properties";
//            }
//            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(appEnv));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


//    public static void timeTask(ScheduledExecutorService timer){
//        timer.scheduleAtFixedRate(new InsertTbTask(),1,5, TimeUnit.MINUTES);
//        log.info("设置定时任务成功");
//    }
//
//    public static class InsertTbTask extends TimerTask {
//        @Override
//        public void run() {
//            try {
//                log.info("运行插入数据库定时任务,[mapsize=[{}]]",maps.size());
//                DateTime date = DateUtil.date();
//                int hour = date.hour(true);
//                maps.forEach((k,v)->{
//                    String[] split = k.split("_");
//                    BsmAlertCnt build = BsmAlertCnt.builder()
//                            .type(Integer.parseInt(split[0]))
//                            .level(Integer.parseInt(split[1]))
//                            .count(v)
//                            .hours(hour)
//                            .time(new Timestamp(System.currentTimeMillis()))
//                            .build();
//                    log.info("insert db,[alert={}]",build);
//                    mapper.insertAlertCount(build);
//                });
//                mapper.idleSelect();
//                maps.clear();
//            }catch (Exception e){
//                log.error("运行插入数据库定时任务,出现错误.[msg={}]",e.getMessage());
//                e.printStackTrace();
//            }
//
//        }
//    }
}

