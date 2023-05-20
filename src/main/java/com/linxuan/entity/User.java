package com.linxuan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户实体类 对应数据库中user表
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // 用户ID
    private Integer userId;
    // 用户名称
    private String userName;
    // 用户密码
    private String userPassword;
    // 用户邮箱 同时也是用户账号
    private String userEmail;
    // 用户角色
    private String userRole;
    // 用户状态 0为正常 1为禁用
    private Character userStatus;
}
