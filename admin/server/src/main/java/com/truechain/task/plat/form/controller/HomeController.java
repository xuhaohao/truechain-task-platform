package com.truechain.task.plat.form.controller;

import com.truechain.task.plat.form.core.WrapMapper;
import com.truechain.task.plat.form.core.Wrapper;
import org.hibernate.type.WrappedMaterializedBlobType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页Controller
 */
@RestController
@RequestMapping("/home")
public class HomeController {


    /**
     * 获取兼职总人数
     */
    @GetMapping("/countPartTimeTotalPeople")
    public Wrapper countPartTimeTotalPeople() {
        return WrapMapper.ok();
    }

    /**
     * 获取总任务数
     */
    @GetMapping("/countTotalTask")
    public Wrapper countTotalTask() {
        return WrapMapper.ok();
    }

    /**
     * 获取完成任务数
     */
    @RequestMapping("/countComplateTask")
    public Wrapper countComplateTask() {
        return WrapMapper.ok();
    }
}
