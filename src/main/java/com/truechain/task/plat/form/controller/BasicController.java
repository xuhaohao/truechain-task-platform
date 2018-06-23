package com.truechain.task.plat.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class BasicController {

    @Autowired
    protected StringRedisTemplate stringRedisTemplate;
}
