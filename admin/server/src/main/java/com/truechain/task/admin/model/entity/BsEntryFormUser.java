package com.truechain.task.admin.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "BsEntryFormUser")
@DynamicUpdate
public class BsEntryFormUser extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "entryFormId")
    private BsEntryForm entryForm;

    @ManyToOne
    @JoinColumn(name = "userId")
    private SysUser user;


}
