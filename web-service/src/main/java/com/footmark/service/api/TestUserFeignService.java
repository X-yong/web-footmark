package com.footmark.service.api;

import com.web.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:07
 */
@FeignClient(value = "web-user")
public interface TestUserFeignService {

    @PostMapping(value = "web-user/user/queryUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
    List<User> queryUserInfo(@RequestBody User user);

    @PostMapping(value = "web-user/user/saveUserInfo", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name = "list", value = "list", required = true, dataType = "List")
    List<User> saveUserInfo(@RequestBody List<User> users);
}
