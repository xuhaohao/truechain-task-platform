package com.truechain.task.plat.form.model.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "AuthRole")
@Entity
@DynamicUpdate
public class AuthRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private Short status;

    @Transient
    private Integer userId;

    @ManyToMany(mappedBy = "roles")
    private List<AuthUser> users;

    @ManyToMany
    @JoinTable(name = "auth_role_resource")
    private List<AuthResource> resources;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public List<AuthUser> getUsers() {
        return users;
    }

    public void setUsers(List<AuthUser> users) {
        this.users = users;
    }

    public List<AuthResource> getResources() {
        return resources;
    }

    public void setResources(List<AuthResource> resources) {
        this.resources = resources;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
