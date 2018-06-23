package com.truechain.task.plat.form.controller;

import com.truechain.task.plat.form.core.WrapMapper;
import com.truechain.task.plat.form.core.Wrapper;
import com.truechain.task.plat.form.model.entity.AuthRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 角色Controller
 */
@RestController("/role")
public class RoleController extends BasicController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    /**
     * 获取角色关联的(roleId)对应用户列表
     */
    @GetMapping("user/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getUserListByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }

    /**
     * 获取角色未关联的用户列
     */
    @GetMapping("user/-/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getUserListExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }


    /**
     * 获取角色(roleId)所被授权的API资源
     */
    @GetMapping("api/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getRestApiExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }

    /**
     * 获取角色(roleId)未被授权的API资源
     */
    @GetMapping("api/-/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getRestApiByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }

    /**
     * 获取角色(roleId)所被授权的menu资源
     */
    @GetMapping("menu/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getMenusByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }

    /**
     * 获取角色(roleId)未被授权的menu资源
     */
    @GetMapping("menu/-/{roleId}/{currentPage}/{pageSize}")
    public Wrapper getMenusExtendByRoleId(@PathVariable Integer roleId, @PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();
    }

    /**
     * 授权资源给角色
     */
    @PostMapping("/authority/resource")
    public Wrapper authorityRoleResource(HttpServletRequest request) {
        return WrapMapper.ok();
    }

    /**
     * 删除对应的角色的授权资源
     */
    @DeleteMapping("/authority/resource/{roleId}/{resourceId}")
    public Wrapper deleteAuthorityRoleResource(@PathVariable Integer roleId, @PathVariable Integer resourceId) {
        return WrapMapper.ok();
    }

    /**
     * 获取角色
     */
    @GetMapping("{currentPage}/{pageSize}")
    public Wrapper getRoles(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return WrapMapper.ok();

    }

    /**
     * 添加角色
     */
    @PostMapping("")
    public Wrapper addRole(@RequestBody AuthRole role) {
        return WrapMapper.ok();
    }

    /**
     * 更新角色
     */
    @PutMapping("")
    public Wrapper updateRole(@RequestBody AuthRole role) {
        return WrapMapper.ok();
    }

    /**
     * 根据角色ID删除角色
     */
    @DeleteMapping("{roleId}")
    public Wrapper deleteRoleByRoleId(@PathVariable Integer roleId) {
        return WrapMapper.ok();
    }


}
