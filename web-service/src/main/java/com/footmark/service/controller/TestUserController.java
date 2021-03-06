package com.footmark.service.controller;

import com.footmark.service.service.TestUserService;
import com.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:37
 */
@RestController
@RequestMapping("web-service")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @PostMapping(value = "/user/queryUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required = false ,dataType = "User")
    public List<User> queryUserInfo(@RequestBody User user) {
        System.out.println("feign 调用成功------------------->");
        List<User> result = testUserService.queryUserInfo(user);
        return result;
    }

    @PostMapping(value = "/user/saveUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
   //@ApiImplicitParam(name ="users" ,value = "users",dataType = "List")
    public void saveUserInfo(@RequestBody List<User> users) {
        testUserService.saveUserInfo(users);
    }
}
