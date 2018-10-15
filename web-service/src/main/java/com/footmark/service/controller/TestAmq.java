package com.footmark.service.controller;

import com.footmark.service.config.RabbitmqConfig;
import com.web.common.util.InterfaceResult;
import com.web.common.footmark.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/12 10:51
 */
@RestController
@RequestMapping(value = "/web-service")
public class TestAmq {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping(value = "/amq/testSend", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required =false ,dataType = "User")
    public InterfaceResult testAmq() {
        for(int i = 1; i < 100; i++) {
            System.out.println("测试发送消息啦啦啦啦啦"+i);

            amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE, new User(i,"zhangsan"+i));
        }
        return new InterfaceResult("200","ok");
    }
}
