package com.linxuan.controller;

import com.linxuan.common.R;
import com.linxuan.entity.Admin;
import com.linxuan.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 前端管理员登录功能
     * @param admin 前端输入的管理员信息
     * @return 返回的管理员信息 或者 登录失败
     */
    @PostMapping("/login")
    public R<Admin> login(@RequestBody Admin admin, HttpServletRequest request) {
        // 获取前端传过来的管理员名称和密码
        String userName = admin.getUsername();
        String passWord = admin.getPassword();

        // 通过管理员名称查询是否有该管理员账户
        admin = adminService.getAdminByUsername(userName);
        if (admin == null) {
            return R.error("管理员名称错误");
        }
        if (!Objects.equals(admin.getPassword(), passWord)) {
            return R.error("密码错误");
        }

        // 将查询出来的数据存入Session并返回对象
        request.getSession().setAttribute("admin", admin.getId());
        return R.success(admin);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        // 将Session中存储的数据删除掉
        request.getSession().removeAttribute("admin");
        // 返回
        return R.success("退出成功");
    }
}
