//package com.mysql.mybatis;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import com.mysql.hikari.HikariDataSourceInit;
//
///**
// * @author yxg
// */
//public class BSMAlarmService {
//
//    private static final String SQL_INSERT = "insert into  bdai_bsm_alert_cnt(type,level,count,hours,time) values (?,?,?,?,?)";
//
//    private static final String SQL_SELECT = "select 1";
//
//    private static Connection connection;
//
//    static {
//        try {
//            //connection = HikariDataSourceInit.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertAlertCount(BsmAlertCnt bsm){
//        try {
//            String value = "(" + bsm.getType() + "," + bsm.getLevel()+ "," +bsm.getCount()+ "," +bsm.getHours()+ "," +bsm.getTime() + ")";
//            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
//            ps.setInt(1,bsm.getType());
//            ps.setInt(2,bsm.getLevel());
//            ps.setInt(3,bsm.getCount());
//            ps.setInt(4,bsm.getHours());
//            ps.setTimestamp(5,bsm.getTime());
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int idleSelect(){
//        try {
//            PreparedStatement ps = connection.prepareStatement(SQL_SELECT);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
