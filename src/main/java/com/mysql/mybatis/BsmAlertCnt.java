package com.mysql.mybatis;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author wangzh
 * @date 2021/12/17
 * @description
 */
@Data
@Builder
public class BsmAlertCnt {
    /**
     * 类型 1 2 3 4
     */
    private Integer type;

    private Integer level;
    private Integer count;
    private Integer hours;
    private Timestamp time;
}
