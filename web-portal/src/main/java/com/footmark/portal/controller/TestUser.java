package com.footmark.portal.controller;

import com.footmark.portal.api.TestConsumFeignService;
import com.footmark.portal.api.TestServiceFeignService;
import com.footmark.portal.api.TestUserFeignService;
import com.common.util.InterfaceResult;
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
 * @Date : 2018/10/10 20:27
 */
@RestController
@RequestMapping("/web-portal")
public class TestUser {

    @Autowired
    private TestUserFeignService testUserFeignService;
    @Autowired
    private TestServiceFeignService testServiceFeignService;

    @Autowired
    private TestConsumFeignService testConsumFeignService;


    @PostMapping(value = "/user/queryUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required =false ,dataType = "User")
    public InterfaceResult queryUserInfo(@RequestBody User user) {
        List<User> result = testUserFeignService.queryUserInfo(user);

        InterfaceResult<List<User>> interfaceResult = new InterfaceResult<>();
        interfaceResult.setData(result);
        interfaceResult.setCode("200");
        interfaceResult.setMsg("ok");

        return interfaceResult;
    }

    @PostMapping(value = "/user/saveUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    //@ApiImplicitParam(name ="list" ,value = "list",required =false ,dataType = "List")
    public InterfaceResult saveUserInfo(@RequestBody List<User> users) {
        testServiceFeignService.saveUserInfo(users);
        InterfaceResult interfaceResult = new InterfaceResult<>();
        interfaceResult.setCode("200");
        interfaceResult.setMsg("ok");

        return interfaceResult;
    }
    @PostMapping(value = "/t/test", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    public InterfaceResult saveUserInfo() {
        testConsumFeignService.test();
        InterfaceResult interfaceResult = new InterfaceResult<>();
        interfaceResult.setCode("200");
        interfaceResult.setMsg("ok");

        return interfaceResult;
    }
}
