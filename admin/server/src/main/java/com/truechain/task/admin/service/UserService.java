package com.truechain.task.admin.service;

import com.truechain.task.admin.model.entity.AuthUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    void addUser(AuthUser user);

    AuthUser getUserById(Integer userId);

    Page<AuthUser> getUserPageByCriteria(AuthUser user, Pageable pageable);

    void addUserRole(Integer userId, Integer roleId);

    void deleteUserRole(Integer userId, Integer roleId);
}
