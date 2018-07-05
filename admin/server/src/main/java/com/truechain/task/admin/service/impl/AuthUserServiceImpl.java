package com.truechain.task.admin.service.impl;

import com.truechain.task.admin.core.BusinessException;
import com.truechain.task.admin.model.entity.AuthUser;
import com.truechain.task.admin.repository.AuthUserRepository;
import com.truechain.task.admin.service.AuthUserService;
import com.truechain.task.admin.util.MD5Util;
import com.truechain.task.admin.model.entity.AuthRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public void addUser(AuthUser user) {
        if (!StringUtils.isEmpty(user.getPassword())) {
            String password = user.getPassword();
            user.setPassword(MD5Util.generate(password));
        }
        authUserRepository.save(user);
    }

    @Override
    public AuthUser getUserById(Long userId) {
        return null;
    }

    @Override
    public Page<AuthUser> getUserPageByCriteria(AuthUser user, Pageable pageable) {
        return authUserRepository.findAll(pageable);
    }


    @Override
    public void addUserRole(Long userId, Long roleId) {
        AuthUser user = getUserById(userId);
        if (null == user) {
            throw new BusinessException("用户不存在");
        }
        AuthRole role = new AuthRole();
        role.setId(roleId);
        if (CollectionUtils.isEmpty(user.getRoles())) {
            user.setRoles(Collections.singletonList(role));
        } else {
            user.getRoles().add(role);
        }
        authUserRepository.save(user);
    }

    @Override
    public void deleteUserRole(Long userId, Long roleId) {
        AuthUser user = getUserById(userId);
        if (null == user) {
            throw new BusinessException("用户不存在");
        }
        if (CollectionUtils.isEmpty(user.getRoles())) {
            AuthRole role = new AuthRole();
            role.setId(roleId);
            user.getRoles().remove(role);
        }
        authUserRepository.save(user);
    }

}
