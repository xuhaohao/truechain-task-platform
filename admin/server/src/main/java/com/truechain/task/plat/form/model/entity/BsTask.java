package com.truechain.task.plat.form.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 任务表
 */
@Table(name = "BsTask")
@DynamicUpdate
public class BsTask extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rewardId")
    private BsReward bsReward;
}
