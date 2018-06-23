package com.truechain.task.plat.form.security.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * PasswordToken
 */
public class PasswordToken implements AuthenticationToken {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;

    private String timestamp;

    private String host;

    private String tokenKey;

    public PasswordToken(String userName, String password, String timestamp, String host, String tokenKey) {
        this.userName = userName;
        this.password = password;
        this.timestamp = timestamp;
        this.host = host;
        this.tokenKey = tokenKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    @Override
    public Object getPrincipal() {
        return this.getUserName();
    }

    @Override
    public Object getCredentials() {
        return this.getPassword();
    }
}
