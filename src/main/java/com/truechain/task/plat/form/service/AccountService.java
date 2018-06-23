package com.truechain.task.plat.form.service;

import com.truechain.task.plat.form.model.entity.AuthUser;

import java.util.Map;

public interface AccountService {

    /**
     * 注册
     *
     * @param authUser
     * @return
     */
    AuthUser register(AuthUser authUser);

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    Map login(String userName, String password);

    /**
     * 刷新Token
     *
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);
}
