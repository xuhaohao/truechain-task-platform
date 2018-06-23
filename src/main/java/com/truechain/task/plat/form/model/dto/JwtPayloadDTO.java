package com.truechain.task.plat.form.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * JwtPayloadDTO
 */
public class JwtPayloadDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 令牌ID
     */
    private String tokenId;
    /**
     * 客户标识
     */
    private String userId;
    /**
     * 签发者
     */
    private String issuer;
    /**
     * 签发时间
     */
    private Date issuedAt;
    /**
     * 接收方
     */
    private String audience;
    /**
     * 访问主张-角色
     */
    private String roles;
    /**
     * 访问主张-资源
     */
    private String perms;
    /**
     * 客户地址
     */
    private String hsot;

    public JwtPayloadDTO() {
    }

    public JwtPayloadDTO(String tokenId, String userId, String issuer, Date issuedAt, String audience, String roles, String perms, String hsot) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.issuer = issuer;
        this.issuedAt = issuedAt;
        this.audience = audience;
        this.roles = roles;
        this.perms = perms;
        this.hsot = hsot;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getHsot() {
        return hsot;
    }

    public void setHsot(String hsot) {
        this.hsot = hsot;
    }
}
