package com.mysql.mybatis;

import org.apache.ibatis.annotations.Param;

public interface AlarmMapper {
    void insertAlertCount(@Param("bsmAlertCnt") BsmAlertCnt bsmAlertCnt);
    int idleSelect();
}
