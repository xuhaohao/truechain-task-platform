package com.truechain.task.admin.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Table;

@Table(name = "SysUser")
@DynamicUpdate
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 账号
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String personName;
    /**
     * 微信昵称
     */
    private String wxNickName;
    /**
     * 电话
     */
    private String tel;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 钱包地址
     */
    private String trueChainAddress;
    /**
     * 简历地址
     */
    private String resumeFilePath;
    /**
     * 状态
     */
    private int status;
    /**
     * 审核状态
     */
    private int auditStatus;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTrueChainAddress() {
        return trueChainAddress;
    }

    public void setTrueChainAddress(String trueChainAddress) {
        this.trueChainAddress = trueChainAddress;
    }

    public String getResumeFilePath() {
        return resumeFilePath;
    }

    public void setResumeFilePath(String resumeFilePath) {
        this.resumeFilePath = resumeFilePath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }
}
