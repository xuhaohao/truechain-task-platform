package com.truechain.task.plat.form.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Table;

/**
 * 更新日志表
 */
@Table(name = "SysUpdateLog")
@DynamicUpdate
public class SysUpdateLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
