package com.linxuan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 借阅记录表 对应数据库中record表
 * 问题：
 * 1.时间不应该使用String类型的
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    // 借阅记录ID
    private Integer recordId;
    // 图书编号
    private Integer bookId;
    // 用户ID
    private Integer userId;
    // 图书借阅时间
    private String recordBorrowtime;
    // 图书归还时间
    private String recordRemandTime;
}
