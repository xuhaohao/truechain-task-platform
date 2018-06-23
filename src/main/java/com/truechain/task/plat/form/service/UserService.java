package com.truechain.task.plat.form.service;

import com.truechain.task.plat.form.model.entity.AuthUser;

public interface UserService {

    AuthUser getUserByUserName(String userName);

    int countByUserName(String userName);

    void addUser(AuthUser user);

}
