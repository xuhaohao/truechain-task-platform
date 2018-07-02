package com.truechain.task.plat.form.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * 奖励
 */
@Table(name = "BsReward")
@DynamicUpdate
public class BsReward extends BaseEntity {



    /**
     * 任务记录
     */
    @OneToMany(mappedBy = "bsReward")
    private Set<BsTask> taskSet;
}
