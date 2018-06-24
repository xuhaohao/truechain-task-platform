package com.truechain.task.plat.form.model.dto;

import java.io.Serializable;

/**
 * SessionPoJo
 */
public class SessionPOJO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
