package com.truechain.task.plat.form.repository;

import com.truechain.task.plat.form.model.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {

    AuthUser findByUsername(String userName);

    int countByUsername(String userName);
}
