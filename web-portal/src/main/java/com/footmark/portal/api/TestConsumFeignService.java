package com.footmark.portal.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:07
 */
@FeignClient(value = "web-consume")
public interface TestConsumFeignService {

    @PostMapping(value = "/consume/t/test", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    void test();
}
