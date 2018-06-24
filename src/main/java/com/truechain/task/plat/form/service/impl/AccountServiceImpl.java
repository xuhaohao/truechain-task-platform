package com.truechain.task.plat.form.service.impl;

import com.truechain.task.plat.form.core.BusinessException;
import com.truechain.task.plat.form.model.dto.LoginDTO;
import com.truechain.task.plat.form.model.dto.SessionPOJO;
import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.repository.AuthUserRepository;
import com.truechain.task.plat.form.security.SessionPOJOService;
import com.truechain.task.plat.form.service.AccountService;
import com.truechain.task.plat.form.util.CommonUtil;
import com.truechain.task.plat.form.util.JwtUtil;
import com.truechain.task.plat.form.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AuthUserRepository userRepository;

    @Autowired
    private SessionPOJOService sessionPoJOService;

    @Override
    public AuthUser register(AuthUser authUser) {
        int count = userRepository.countByUsername(authUser.getUsername());
        if (count > 0) {
            throw new BusinessException("账号已注册");
        }
        authUser.setPassword(MD5Util.generate(authUser.getPassword()));
        return userRepository.save(authUser);
    }

    @Override
    public LoginDTO login(String userName, String password) {
        AuthUser authUser = userRepository.findByUsername(userName);
        if (authUser == null) {
            throw new BusinessException("用户不存在");
        }
        String realPass = authUser.getPassword();
        if (!MD5Util.verify(password, realPass)) {
            throw new BusinessException("密码不正确");
        }
        SessionPOJO sessionPOJO = sessionPoJOService.initSession(authUser);
        String salt = CommonUtil.getRandomString(6);
        String token = JwtUtil.createToken(salt, sessionPOJO.getId(), 10000L);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserUid(authUser.getId());
        loginDTO.setSalt(salt);
        loginDTO.setToken(token);
        return loginDTO;
    }

    @Override
    public String refreshToken(String oldToken) {
        throw new UnsupportedOperationException();
    }
}
