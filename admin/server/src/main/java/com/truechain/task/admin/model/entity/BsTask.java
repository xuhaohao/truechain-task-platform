package com.truechain.task.admin.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 任务表
 */
@Table(name = "BsTask")
@DynamicUpdate
public class BsTask extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 任务状态
     */
    private int status;
    /**
     * 报名单
     */
    @ManyToOne
    @JoinColumn(name = "rewardId")
    private BsReward bsReward;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BsReward getBsReward() {
        return bsReward;
    }

    public void setBsReward(BsReward bsReward) {
        this.bsReward = bsReward;
    }
}
