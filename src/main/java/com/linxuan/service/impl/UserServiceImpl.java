package com.linxuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linxuan.dao.UserDao;
import com.linxuan.dto.RecordDto;
import com.linxuan.entity.User;
import com.linxuan.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有账号开启着的借阅者信息
     * @return 返回所有借阅者信息
     */
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * 添加借阅者信息
     * @param user 需要添加的借阅者信息
     * @return 返回是否成功
     */
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 修改借阅者信息
     * @param user 需要修改的借阅者信息
     */
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * 删除借阅者信息
     * @param id 需要删除的借阅者ID
     * @return 返回影响结果行数
     */
    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    /**
     * 查询所有借阅者结束情况
     * @return 返回
     */
    @Override
    public PageInfo<RecordDto> getAllUserAndRecord(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<RecordDto> recordDtolist = userDao.getAllUserAndRecord();
        return new PageInfo<>(recordDtolist);
    }

}
