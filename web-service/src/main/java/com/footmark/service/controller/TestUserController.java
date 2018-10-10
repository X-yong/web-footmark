package com.footmark.service.controller;

import com.web.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:37
 */
@RestController
@RequestMapping("web-service")
public class TestUserController {



    @PostMapping(value = "/test-one", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required = false ,dataType = "User")
    public void testUser(@RequestBody User user) {
        System.err.println("用户id："+user.getId());
        System.err.println("用户名："+user.getName());
        System.out.println("feign 调用成功------------------->");
    }
}
