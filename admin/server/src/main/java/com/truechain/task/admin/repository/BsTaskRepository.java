package com.truechain.task.admin.repository;

import com.truechain.task.admin.model.entity.BsTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsTaskRepository extends JpaRepository<BsTask, Long> {
}
