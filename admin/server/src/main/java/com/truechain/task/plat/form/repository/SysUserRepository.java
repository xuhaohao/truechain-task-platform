package com.truechain.task.plat.form.repository;

import com.truechain.task.plat.form.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
}
