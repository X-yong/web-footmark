package com.footmark.portal.api;

import com.web.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:07
 */
@FeignClient(value = "web-service")
public interface TestUserFeignService {

    @PostMapping(value = "web-service/test-one", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
    void testUser(@RequestBody  User user);
}
