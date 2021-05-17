package com.yuanian.encry.controller;

import com.yuanian.encry.entity.TenantDbConnInfoVO;
import com.yuanian.encry.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhahsh
 * @date 2021/5/8
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/test")
    public String testRedis(){
        if (!redisUtil.hasKey("10000429")){
            redisUtil.set("10000429", new TenantDbConnInfoVO("com.mysql.cj.jdbc.Driver","mysql","192.168.48.14","3306","mapping_dev","mapdbadev","1qaz@WSX"), -1);
            redisUtil.set("10000428", new TenantDbConnInfoVO("com.mysql.cj.jdbc.Driver","mysql","192.168.48.14","3306","mapping_test","mapdbadev","1qaz@WSX"), -1);
        }


        System.out.println(redisUtil.get("test:01"));
        return redisUtil.get("test:01").toString();
    }
}
