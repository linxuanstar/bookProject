package com.linxuan.service;

import com.linxuan.entity.Admin;
import com.linxuan.entity.User;

public interface AdminService {

    /**
     * 根据前端传过来的管理员名称查询是否有该管理员存在
     * @param userName 管理员名称
     * @return 查询结果
     */
    Admin getAdminByUsername(String userName);
}
