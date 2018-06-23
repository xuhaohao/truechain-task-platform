package com.truechain.task.plat.form.service.impl;

import com.truechain.task.plat.form.model.entity.AuthUser;
import com.truechain.task.plat.form.repository.AuthUserRepository;
import com.truechain.task.plat.form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthUserRepository userRepository;

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
}
