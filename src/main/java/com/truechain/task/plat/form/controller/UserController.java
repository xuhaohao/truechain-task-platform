package com.truechain.task.plat.form.controller;

import com.truechain.task.plat.form.core.WrapMapper;
import com.truechain.task.plat.form.core.Wrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户Controller
 */
public class UserController extends BasicController {


    /**
     * 获取用户列表
     *
     * @param start
     * @param limit
     * @return
     */
    public Wrapper getUserList(@PathVariable Integer start, @PathVariable Integer limit) {
        return WrapMapper.ok();
    }

    /**
     * 获取对应用户角色
     */
    @GetMapping("/role/{appId}")
    public Wrapper getUserRoleList(@PathVariable String appId) {
        return WrapMapper.ok();
    }

    /**
     * 给用户授权添加角色
     */
    @PostMapping("/authority/role")
    public Wrapper authorityUserRole(HttpServletRequest request) {
        return WrapMapper.ok();
    }

    /**
     * 删除已经授权的用户角色
     */
    @DeleteMapping("/authority/role/{uid}/{roleId}")
    public Wrapper deleteAuthorityUserRole(@PathVariable String uid, @PathVariable Integer roleId) {
        return WrapMapper.ok();
    }


    /**
     * 用户登出
     */
    @PostMapping("/exit")
    public Wrapper accountExit(HttpServletRequest request) {
        return WrapMapper.ok();
    }
}
