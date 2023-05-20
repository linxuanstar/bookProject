package com.linxuan.dao;

import com.linxuan.entity.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminDao {

    /**
     * 根据管理员名称来判断是否存在该用户
     * @param userName 管理员名称
     * @return 返回查询结果
     */
    @Select("select * from admin where username = #{userName}")
    Admin getAdminByUserName(String userName);
}
