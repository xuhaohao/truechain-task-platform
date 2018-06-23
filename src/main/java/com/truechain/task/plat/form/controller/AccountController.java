package com.truechain.task.plat.form.controller;

import com.google.common.base.Preconditions;
import com.truechain.task.plat.form.core.BusinessException;
import com.truechain.task.plat.form.core.WrapMapper;
import com.truechain.task.plat.form.core.Wrapper;
import com.truechain.task.plat.form.model.entity.AuthRole;
import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.service.UserService;
import com.truechain.task.plat.form.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 账户Controller
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BasicController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @return
     */
    @PostMapping("/register")
    public Wrapper register(@RequestBody AuthUser user) {
        Preconditions.checkArgument(!StringUtils.isEmpty(user.getUsername()), "账户信息缺失");
        Preconditions.checkArgument(!StringUtils.isEmpty(user.getPassword()), "账户信息缺失");
        int countUser = userService.countByUserName(user.getUsername());
        if (countUser > 0) {
            throw new BusinessException("账户已存在");
        }
        userService.addUser(user);
        return WrapMapper.ok();
    }

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("/login")
    public Wrapper login(@RequestParam String userName, @RequestParam String password) {
        AuthUser user = userService.getUserByUserName(userName);
        List<AuthRole> roleList = user.getRoles();
        String roles = "";
        String resources = "";
        long refreshPeriodTime = 36000L;
        String token = JwtUtil.createToken(userName, roles, resources, refreshPeriodTime >> 2);
        stringRedisTemplate.opsForValue().set("JWT_SESSION_" + userName, token, refreshPeriodTime, TimeUnit.SECONDS);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        user.setSalt(null);
        user.setPassword(null);
        user.setRoles(null);
        result.put("user", user);
        return WrapMapper.ok(result);
    }


}
