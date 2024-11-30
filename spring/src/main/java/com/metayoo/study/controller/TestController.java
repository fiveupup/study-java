package com.metayoo.study.controller;

import com.metayoo.study.entity.CmsTenant;
import com.metayoo.study.mapper.CmsTenantMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private CmsTenantMapper cmsTenantMapper;

    @GetMapping("/test")
    public Object test() {
        CmsTenant cmsTenant = cmsTenantMapper.selectById(1);
        return cmsTenant;
    }
}
