package com.linxuan.service;

import com.github.pagehelper.PageInfo;
import com.linxuan.dto.RecordDto;
import com.linxuan.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 如果是配置文件开发（或者混合开发），那么就是用这种方式加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 测试查询所有借阅者信息方法
     */
    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    /**
     * 测试添加借阅者信息
     */
    @Test
    public void testInsertUser() {
        User user = new User(null, "111", "111", "111", "111", '0');
        if (userService.insertUser(user) > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 测试删除借阅者信息
     */
    @Test
    public void testDeleteUser() {
        if (userService.deleteUser(3) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 测试查询所有借阅者借书情况
     */
    @Test
    public void testSelectUserAndRecord() {
        PageInfo<RecordDto> pageInfo = userService.getAllUserAndRecord(1, 5);
        System.out.println(pageInfo);
    }
}
