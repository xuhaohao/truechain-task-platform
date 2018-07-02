package com.truechain.task.plat.form.repository;

import com.truechain.task.plat.form.model.entity.BsTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsTaskRepository extends JpaRepository<BsTask, Long> {
}
