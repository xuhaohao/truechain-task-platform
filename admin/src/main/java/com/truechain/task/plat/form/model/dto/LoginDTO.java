package com.truechain.task.plat.form.model.dto;

import java.io.Serializable;

/**
 * 登录DTO
 */
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userUid;

    private String token;

    private String agent;

    public Integer getUserUid() {
        return userUid;
    }

    public void setUserUid(Integer userUid) {
        this.userUid = userUid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
