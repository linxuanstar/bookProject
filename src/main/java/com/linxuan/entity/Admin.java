package com.linxuan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员类，对应管理员admin表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    // 管理员ID
    private Integer id;
    // 管理员名称
    private String username;
    // 管理员密码
    private String password;
}
