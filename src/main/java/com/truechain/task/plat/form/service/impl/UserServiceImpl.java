package com.truechain.task.plat.form.service.impl;

import com.truechain.task.plat.form.core.BusinessException;
import com.truechain.task.plat.form.model.dto.AccountDTO;
import com.truechain.task.plat.form.model.entity.AuthRole;
import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.repository.AuthUserRepository;
import com.truechain.task.plat.form.service.UserService;
import com.truechain.task.plat.form.util.CommonUtil;
import com.truechain.task.plat.form.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthUserRepository userRepository;

    @Override
    public AuthUser getUserById(Integer userId) {
        return null;
    }

    @Override
    public AuthUser getUserByUserName(String userName) {
        AuthUser authUser = userRepository.findByUsername(userName);
        return authUser;
    }

    @Override
    public int countByUserName(String userName) {
        return userRepository.countByUsername(userName);
    }

    @Override
    public void addUser(AuthUser user) {
        String salt = CommonUtil.getRandomString(6);
        String realPassword = MD5Util.md5(user.getPassword() + salt);
        user.setPassword(realPassword);
        user.setSalt(salt);
        userRepository.save(user);
    }

    @Override
    public Page<AuthUser> getUserPageByCriteria(Pageable pageable) {
        return null;
    }

    @Override
    public void addUserRole(AuthRole role) {
        AuthUser user = getUserById(role.getUserId());
        if (null == user) {
            throw new BusinessException("用户不存在");
        }
        if (CollectionUtils.isEmpty(user.getRoles())) {
            user.setRoles(Collections.singletonList(role));
        } else {
            user.getRoles().add(role);
        }
        userRepository.save(user);
    }

    @Override
    public AccountDTO getAccount(String userName) {
        return null;
    }
}
