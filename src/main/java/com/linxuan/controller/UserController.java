package com.linxuan.controller;

import com.github.pagehelper.PageInfo;
import com.linxuan.common.R;
import com.linxuan.dto.RecordDto;
import com.linxuan.entity.User;
import com.linxuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 借阅者控制层
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return 返回查询出来的所有用户
     */
    @GetMapping
    public R<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return R.success(users);
    }

    /**
     * 删除借阅者信息
     * @param id 需要删除的借阅者信息的ID
     * @return 返回是否删除成功
     */
    @DeleteMapping("/delete")
    public R<String> deleteUser(Integer id) {
        if (userService.deleteUser(id) > 0) {
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }

    /**
     * 新增借阅者信息
     * @param user 需要新增的借阅者信息
     * @return 返回是否新增成功
     */
    @PostMapping()
    public R<String> insert(@RequestBody User user) {
        log.info("前端传过来User数据：" + user);
        if (userService.insertUser(user) > 0) {
            return R.success("新增成功");
        }
        return R.error("新增失败");
    }

    /**
     * 修改借阅者信息
     * @param user 前端传过来借阅者信息
     * @return 返回修改成功
     */
    @PutMapping()
    public R<String> update(@RequestBody User user) {
        log.info("前端传过来的数据：" + user);
        userService.updateUser(user);
        return R.success("修改成功");
    }

    @GetMapping("/record")
    public R<PageInfo<RecordDto>> getUserAndRecord(Integer page, Integer pageSize) {
        PageInfo<RecordDto> pageInfo = userService.getAllUserAndRecord(page, pageSize);
        return R.success(pageInfo);
    }
}
