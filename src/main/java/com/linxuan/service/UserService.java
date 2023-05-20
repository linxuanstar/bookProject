package com.linxuan.service;

import com.github.pagehelper.PageInfo;
import com.linxuan.dto.RecordDto;
import com.linxuan.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {

    /**
     * 查询所有账号开启着的借阅者信息
     * @return 返回所有借阅者信息
     */
    List<User> getAllUsers();


    /**
     * 添加借阅者信息
     * @param user 需要添加的借阅者信息
     * @return 返回是否成功
     */
    int insertUser(User user);

    /**
     * 修改借阅者信息
     * @param user 需要修改的借阅者信息
     */
    void updateUser(User user);

    /**
     * 删除借阅者信息
     * @param id 需要删除的借阅者ID
     * @return 返回影响结果行数
     */
    int deleteUser(@Param("id") int id);

    /**
     * 查询所有借阅者结束情况
     * @return 返回
     */
    PageInfo<RecordDto> getAllUserAndRecord(int page, int pageSize);
}
