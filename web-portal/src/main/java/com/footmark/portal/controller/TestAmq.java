package com.footmark.portal.controller;

import com.footmark.portal.config.RabbitmqConfig;
import com.web.common.util.InterfaceResult;
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
@RequestMapping(value = "/web-portal")
public class TestAmq {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping(value = "/amq/testSend", consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "测试", notes = "测试")
    @ApiImplicitParam(name ="user" ,value = "user",required =false ,dataType = "User")
    public InterfaceResult testAmq() {
        System.out.println("测试消息发送"+amqpTemplate);
        amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE, "测试消息啦啦啦啦啦");
        return new InterfaceResult("200","ok");
    }
}
