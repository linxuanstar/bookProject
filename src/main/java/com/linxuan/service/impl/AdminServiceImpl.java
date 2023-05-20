package com.linxuan.service.impl;

import com.linxuan.dao.AdminDao;
import com.linxuan.entity.Admin;
import com.linxuan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    /**
     * 根据前端传过来的管理员名称查询是否有该管理员存在
     * @param userName 管理员名称
     * @return 查询结果
     */
    @Override
    public Admin getAdminByUsername(String userName) {
        // 根据管理员名称来查询数据库中是否用该管理员
        return adminDao.getAdminByUserName(userName);
    }
}
