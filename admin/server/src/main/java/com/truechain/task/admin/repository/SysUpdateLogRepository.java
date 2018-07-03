package com.truechain.task.admin.repository;

import com.truechain.task.admin.model.entity.SysUpdateLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUpdateLogRepository extends JpaRepository<SysUpdateLog, Long> {
}
