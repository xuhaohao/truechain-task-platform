package com.truechain.task.admin.controller;

import com.truechain.task.admin.core.WrapMapper;
import com.truechain.task.admin.core.Wrapper;
import com.truechain.task.admin.model.entity.AuthRole;
import com.truechain.task.admin.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * 角色Controller
 */
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController extends BasicController {

    private static final Logger logger = LoggerFactory.getLogger(AdminRoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 授权资源给角色
     */
    @PostMapping("/authorityRoleResource")
    public Wrapper authorityRoleResource(@RequestParam Integer roleId, @RequestParam Long resourceId) {
        roleService.addRoleResource(roleId, resourceId);
        return WrapMapper.ok();
    }

    /**
     * 删除对应的角色的授权资源
     */
    @DeleteMapping("/deleteAuthorityRoleResource")
    public Wrapper deleteAuthorityRoleResource(@RequestParam Integer roleId, @RequestParam Long resourceId) {
        roleService.deleteRoleResource(roleId, resourceId);
        return WrapMapper.ok();
    }

    /**
     * 获取角色
     */
    @PostMapping("/getRolePage")
    public Wrapper getRolePage(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        Pageable pageable = new PageRequest(pageIndex - 1, pageSize);
        Page<AuthRole> rolePage = roleService.getRolePageByCriteria(null, pageable);
        return WrapMapper.ok(rolePage);

    }

    /**
     * 添加角色
     */
    @PostMapping("/addRole")
    public Wrapper addRole(@RequestBody AuthRole role) {
        roleService.addRole(role);
        return WrapMapper.ok();
    }

    /**
     * 更新角色
     */
    @PostMapping("/updateRole")
    public Wrapper updateRole(@RequestBody AuthRole role) {
        roleService.updateRole(role);
        return WrapMapper.ok();
    }

    /**
     * 根据角色ID删除角色
     */
    @PostMapping("/deleteRole")
    public Wrapper deleteRoleByRoleId(@RequestParam Integer roleId) {
        roleService.deleteRoleByRoleId(roleId);
        return WrapMapper.ok();
    }


}
