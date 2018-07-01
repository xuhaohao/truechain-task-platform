package com.truechain.task.plat.form.service;

import com.truechain.task.plat.form.model.entity.AuthResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResourceService {

    Page<AuthResource> getResourcePageByCriteria(AuthResource resource, Pageable pageable);

    void addResource(AuthResource resource);

    void updateResource(AuthResource resource);

    void deleteResource(Integer resourceId);
}
