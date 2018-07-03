package com.truechain.task.api.controller;

import com.truechain.task.api.core.WrapMapper;
import com.truechain.task.api.core.Wrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户Controller
 */
@RestController
@RequestMapping(value = "/unauth/account")
public class AccountController extends BasicController {

    /**
     * 注册
     */
    @PostMapping("/register")
    public Wrapper register() {
        return WrapMapper.ok();
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Wrapper login() {
        return WrapMapper.ok();
    }

    /**
     * 获取验证码
     */
    @GetMapping("/verifyCode/{mobile}")
    public Wrapper getVerifyCode() {
        return WrapMapper.ok();
    }
}
