package com.truechain.task.plat.form.controller;

import com.truechain.task.plat.form.core.WrapMapper;
import com.truechain.task.plat.form.core.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源Controller
 */
@RestController
@RequestMapping("/resource")
public class ResourceController extends BasicController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    /**
     * 获取用户授权的菜单
     */
    public Wrapper getAuthorityMenu() {
        return WrapMapper.ok();
    }

    /**
     * 获取全部菜单
     *
     * @return
     */
    public Wrapper getMenus() {
        return WrapMapper.ok();
    }

    /**
     * 添加菜单
     *
     * @return
     */
    public Wrapper addMenu() {
        return WrapMapper.ok();
    }

    /**
     * 修改菜单
     *
     * @return
     */
    public Wrapper updateMenu() {
        return WrapMapper.ok();
    }

    /**
     * 删除菜单
     *
     * @return
     */
    public Wrapper deleteMenu() {
        return WrapMapper.ok();
    }
}
