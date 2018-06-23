package com.truechain.task.plat.form.service.impl;

import com.truechain.task.plat.form.core.BusinessException;
import com.truechain.task.plat.form.model.entity.AuthRole;
import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.repository.AuthUserRepository;
import com.truechain.task.plat.form.service.UserService;
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
        return userRepository.findByUsername(userName);
    }

    @Override
    public int countByUserName(String userName) {
        return userRepository.countByUsername(userName);
    }

    @Override
    public void addUser(AuthUser user) {
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
}
