package com.linxuan.dto;

import com.linxuan.entity.Record;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto extends Record {
    // 借阅者姓名
    private String userName;
    // 借阅者邮箱
    private String userEmail;
    // 借阅者状态
    private Character userStatus;
    // 加上图书名称
    private String bookName;
}
