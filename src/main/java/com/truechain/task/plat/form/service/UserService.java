package com.truechain.task.plat.form.service;

import com.truechain.task.plat.form.model.entity.AuthRole;
import com.truechain.task.plat.form.model.entity.AuthUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    AuthUser getUserById(Integer userId);

    AuthUser getUserByUserName(String userName);

    int countByUserName(String userName);

    void addUser(AuthUser user);

    Page<AuthUser> getUserPageByCriteria(Pageable pageable);

    void addUserRole(AuthRole role);
}
