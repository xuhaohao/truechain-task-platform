package com.truechain.task.admin.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 报名表
 */
@Table(name = "BsEntryForm")
@DynamicUpdate
public class BsEntryForm extends BaseEntity {

    private int type;

    @OneToOne
    @JoinColumn(name = "taskId")
    private BsTask task;


}
