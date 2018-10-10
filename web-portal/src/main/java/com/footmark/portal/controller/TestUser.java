package com.footmark.portal.controller;

import com.footmark.portal.api.TestUserFeignService;
import com.web.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:27
 */
@RestController
@RequestMapping("/web-portal")
public class TestUser {

    @Autowired
    private TestUserFeignService testUserFeignService;


    @PostMapping(value = "/test-one", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required =false ,dataType = "User")
    public void testUser(@RequestBody User user) {
        System.out.println("feign 调用测试开始");
        testUserFeignService.testUser(user);
        System.out.println("调用结束");
    }
}
