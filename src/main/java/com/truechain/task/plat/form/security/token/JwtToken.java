package com.truechain.task.plat.form.security.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JWT TOKEN
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户IP
     */
    private String ipHost;
    /**
     * 设备信息
     */
    private String deviceInfo;
    /**
     * json web token
     */
    private String jwt;

    public JwtToken(String userName, String ipHost, String deviceInfo, String jwt) {
        this.userName = userName;
        this.ipHost = ipHost;
        this.deviceInfo = deviceInfo;
        this.jwt = jwt;
    }

    @Override
    public Object getPrincipal() {
        return this.getUserName();
    }

    @Override
    public Object getCredentials() {
        return this.getJwt();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
